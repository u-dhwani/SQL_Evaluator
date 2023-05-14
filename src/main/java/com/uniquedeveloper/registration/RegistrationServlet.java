package com.uniquedeveloper.registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studid=request.getParameter("studentid");
		String uname=request.getParameter("name");
		String email=request.getParameter("email");
		String upwd=request.getParameter("pass");
		RequestDispatcher dispatcher=null;
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aliens?useSSL=false","root","Sdkk@1702");
			PreparedStatement pst=con.prepareStatement("insert into users(studid,uname,email,upwd) values(?,?,?,?)");
			pst.setString(1, studid);
			pst.setString(2, uname);
			pst.setString(3, email);
			pst.setString(4, upwd);
			
			int rowCount=pst.executeUpdate();
			dispatcher=request.getRequestDispatcher("registration.jsp");
			if(rowCount>0) {
				request.setAttribute("status", "success");
			}
			else {
				request.setAttribute("status", "failed");
			}
			dispatcher.forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
//		PrintWriter out=response.getWriter();
//		out.print(studid);
//		out.print(uname);
//		out.print(email);
//		out.print(upwd);
		
	}

}

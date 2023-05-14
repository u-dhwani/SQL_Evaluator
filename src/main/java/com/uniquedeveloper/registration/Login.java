package com.uniquedeveloper.registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studid=request.getParameter("studentid");
		String upwd=request.getParameter("password");
		HttpSession session=request.getSession();
		session.setAttribute("names", studid);
		RequestDispatcher dispatcher=null;
		
		/*
		 * String name = request.getParameter("studentid"); System.out.print(name);
		 */
		
		/*
		 * request.setAttribute("studid", studid); RequestDispatcher rd =
		 * request.getRequestDispatcher("Start_Quiz"); rd.forward(request, response);
		 */
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aliens?useSSL=false","root","Sdkk@1702");
			PreparedStatement pst=con.prepareStatement("select * from users where studid=? and upwd=?");
			pst.setString(1, studid);
			pst.setString(2, upwd);
			ResultSet rs=pst.executeQuery();
			
			if(rs.next()) {
				session.setAttribute("studentid", rs.getString("studid"));
				
				// request.setAttribute("name", studid);
				dispatcher=request.getRequestDispatcher("Start_Quiz.jsp");
						
			}
			else {
				request.setAttribute("status", "failed");
				dispatcher=request.getRequestDispatcher("login.jsp");
			}
			dispatcher.forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
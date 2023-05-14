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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/score_page")
public class Score_Page extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aliens?useSSL=false","root","Sdkk@1702");
			
			Statement st = con.createStatement();		
			
			String sql = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'student_score'";
			ResultSet rs = st.executeQuery(sql);
			
			List<String> columnNames = new ArrayList<>();
			while (rs.next()) {
			    String columnName = rs.getString("COLUMN_NAME");
			    columnNames.add(columnName);
			}
			request.setAttribute("columnNames", columnNames);
			
			List<String> column_Name = (List<String>) request.getAttribute("columnNames");
//			for (String columnName : column_Name) {
////				String x=String.format("UPDATE student_score SET %s = %s + %s + %s + %s + %s + %s + %s + %s + %s + %s",total_score,q1_score,
////						q2_score,q3_score,q4_score,q5_score,q6_score,q7_score,g8_score,q9_score,q10_score);
////				st.execute(x);
////			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();	
		}
	}
}

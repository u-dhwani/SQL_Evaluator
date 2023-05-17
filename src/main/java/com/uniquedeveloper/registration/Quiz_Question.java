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

@WebServlet("/quiz_question")
public class Quiz_Question extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int count=0;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String student_answer_1=request.getParameter("answer_q1");
		String student_answer_2=request.getParameter("answer_q2");
		String student_answer_3=request.getParameter("answer_q3");
		String student_answer_4=request.getParameter("answer_q4");
		String student_answer_5=request.getParameter("answer_q5");
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("names");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = null;
		Statement s = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aliens?useSSL=false","root","Sdkk@1702");
			s = con.createStatement();
			
//			String student_score_zero = String.format("Insert into student_score (studid, %s) values ('%s', %d) ON DUPLICATE KEY UPDATE %s = %d", 0, name, 0, 0, 0);
//    	    s.execute(student_score_zero);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		RequestDispatcher dispatcher = null;
		
		
		String admin_answer,qno; 
		
		if(student_answer_1!=null) {
			qno="q1_score";
			String admin_table="CREATE TABLE IF NOT EXISTS dhwani_admin(BID INTEGER,TITLE VARCHAR(20),PUBNAME VARCHAR(20),"
					+ "ANAME VARCHAR(20),NOOFCOPIES INTEGER);";
			admin_answer="SELECT B.BID, B.TITLE, B.PUBNAME, A.ANAME,C.NOOFCOPIES FROM BOOK B, BOOK_AUTHORS A, BOOK_COPIES C, LIBRARY_BRANCH L WHERE B.BID=A.BID AND B.BID=C.BID AND L.BRANCHID=C.BRANCHID;\r\n"
					+ "";
			String student_table_create="CREATE TABLE IF NOT EXISTS "+name+" AS SELECT * FROM dhwani_admin;";
			String extra6="Truncate table "+name;
			String output_admin_stu="CREATE TABLE IF NOT EXISTS outputtable(BID INTEGER,TITLE VARCHAR(20),PUBNAME VARCHAR(20),"
					+ "ANAME VARCHAR(20),NOOFCOPIES INTEGER);";
    		
    		try {
				s.execute(admin_table);
				s.execute(admin_answer);
				s.execute(student_table_create);
				s.execute(extra6);
				s.execute(output_admin_stu);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		String output="Select * from dhwani_admin natural join "+name+" where dhwani_admin.bid = "+name+".bid";
    		
			evaluation(qno,student_answer_1,name,admin_answer,output_admin_stu,output);
			String extra="drop table dhwani_admin";
			String extra5="drop table "+name;
			String extra3="drop table outputtable;";
			try {
				s.execute(extra);
				s.execute(extra5);
				s.execute(extra3);	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(student_answer_2!=null) {
			qno="q2_score";
			String admin_table="CREATE TABLE IF NOT EXISTS dhwani_admin(CARDNO INTEGER);";
			admin_answer="SELECT CARDNO FROM BOOKLENDING WHERE DATEOUT BETWEEN '2017-01-01' AND '2022-06-01' GROUP BY CARDNO HAVING COUNT(*)>3;\r\n"
					+ "";
			String student_table_create="CREATE TABLE IF NOT EXISTS "+name+" AS SELECT * FROM dhwani_admin;";
			String extra6="Truncate table "+name;
			String output_admin_stu="CREATE TABLE IF NOT EXISTS outputtable(CARDNO INTEGER);";
    		
    		try {
				s.execute(admin_table);
				s.execute(admin_answer);
				s.execute(student_table_create);
				s.execute(extra6);
				s.execute(output_admin_stu);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		String output="Select * from dhwani_admin natural join "+name+" where dhwani_admin.CARDNO = "+name+".CARDNO";
    		
			evaluation(qno,student_answer_2,name,admin_answer,output_admin_stu,output);
			String extra="drop table dhwani_admin";
			String extra5="drop table "+name;
			String extra3="drop table outputtable;";
			try {
				s.execute(extra);
				s.execute(extra5);
				s.execute(extra3);	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			admin_answer="select studname from student where studid=2";
//			String student_table_create="CREATE TABLE "+name+" AS SELECT * FROM dhwani_admin;";
//			String output_admin_stu="";
//			evaluation(qno,student_answer_2,name,admin_answer,output_admin_stu);
		}
		if(student_answer_3!=null) {
			qno="q3_score";
			String admin_table="CREATE TABLE IF NOT EXISTS dhwani_admin(PHONE bigint, ADDRESS VARCHAR(20));";
			admin_answer="select phone,address from publisher join book where book.pubname=publisher.name and title=\"DBMS\";\r\n"
					+ "";
			String student_table_create="CREATE TABLE IF NOT EXISTS "+name+" AS SELECT * FROM dhwani_admin;";
			String extra6="Truncate table "+name;
			String output_admin_stu="CREATE TABLE IF NOT EXISTS outputtable(PHONE bigint, ADDRESS VARCHAR(20));";
    		
    		try {
				s.execute(admin_table);
				s.execute(admin_answer);
				s.execute(student_table_create);
				s.execute(extra6);
				s.execute(output_admin_stu);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		String output="Select * from dhwani_admin natural join "+name+" where dhwani_admin.phone = "+name+".phone";
    		
			evaluation(qno,student_answer_3,name,admin_answer,output_admin_stu,output);
			String extra="drop table dhwani_admin";
			String extra5="drop table "+name;
			String extra3="drop table outputtable;";
			try {
				s.execute(extra);
				s.execute(extra5);
				s.execute(extra3);	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if(student_answer_4!=null) {
			qno="q4_score";
			String admin_table="CREATE TABLE IF NOT EXISTS dhwani_admin(BID INTEGER,TITLE VARCHAR(20),NOOFCOPIES INTEGER,ADDRESS VARCHAR(20));";
			admin_answer="select book.bid,title,noofcopies,address from library_branch join book_copies join book where library_branch.branchid=book_copies.branchid and book_copies.bid=book.bid and bname='RR NAGAR';\r\n"
					+ "";
			String student_table_create="CREATE TABLE IF NOT EXISTS "+name+" AS SELECT * FROM dhwani_admin;";
			String extra6="Truncate table "+name;
			String output_admin_stu="CREATE TABLE IF NOT EXISTS outputtable(BID INTEGER,TITLE VARCHAR(20),NOOFCOPIES INTEGER,ADDRESS VARCHAR(20));";
    		
    		try {
				s.execute(admin_table);
				s.execute(admin_answer);
				s.execute(student_table_create);
				s.execute(extra6);
				s.execute(output_admin_stu);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		String output="Select * from dhwani_admin natural join "+name+" where dhwani_admin.bid = "+name+".bid";
    		
			evaluation(qno,student_answer_4,name,admin_answer,output_admin_stu,output);
			String extra="drop table dhwani_admin";
			String extra5="drop table "+name;
			String extra3="drop table outputtable;";
			try {
				s.execute(extra);
				s.execute(extra5);
				s.execute(extra3);	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}
		if(student_answer_5!=null) {
			qno="q5_score";
			String admin_table="CREATE TABLE IF NOT EXISTS dhwani_admin(ANAME VARCHAR(20);";
			admin_answer="select aname from book join book_authors on book.bid=book_authors.bid where title LIKE 'C%';\r\n"
					+ "";
			String student_table_create="CREATE TABLE IF NOT EXISTS "+name+" AS SELECT * FROM dhwani_admin;";
			String extra6="Truncate table "+name;
			String output_admin_stu="CREATE TABLE IF NOT EXISTS outputtable(ANAME VARCHAR(20));";
    		
    		try {
				s.execute(admin_table);
				s.execute(admin_answer);
				s.execute(student_table_create);
				s.execute(extra6);
				s.execute(output_admin_stu);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		String output="Select * from dhwani_admin natural join "+name+" where dhwani_admin.aname = "+name+".aname";
    		
			evaluation(qno,student_answer_5,name,admin_answer,output_admin_stu,output);
			String extra="drop table dhwani_admin";
			String extra5="drop table "+name;
			String extra3="drop table outputtable;";
			try {
				s.execute(extra);
				s.execute(extra5);
				s.execute(extra3);	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}
		
		// Function
		
	}
	public void evaluation(String qno,String fetch,String name,String admin_answer,String output_admin_stu,String output) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aliens?useSSL=false","root","Sdkk@1702");
			
			Statement st = con.createStatement();
			 
			String que_no="q1_score";
            String student_score_ini = String.format("Insert into student_score (studid, %s) values ('%s', %d) ON DUPLICATE KEY UPDATE %s = %d", que_no, name, 0, qno, 0);
	    	st.execute(student_score_ini);	
    		
			String del_student="Truncate table " + name;
			st.execute(del_student);
    		
//    		String del_admin="Truncate table dhwani_admin";
//			st.execute(del_admin);
//			
			String admin_ans="Insert into dhwani_admin " + admin_answer;
			st.execute(admin_ans);
			
    		String student_ans="Insert into "+ name+" "+ fetch; 
    		
    	    st.execute(student_ans);
    	   
    		
    		//PreparedStatement pst=con.prepareStatement("student_ans");
    		
    		st.execute(output_admin_stu);
    		
    		String out_stu_adm="Truncate table outputtable";
			st.execute(out_stu_adm);
    		
    		String result="Insert into outputtable "+output;
    		st.execute(result);
    		
    		String count_admin="Select count(*) from dhwani_admin";
    		ResultSet rs = st.executeQuery(count_admin);
    	    rs.next();
    	    int cnt_admin = rs.getInt(1);
    	    System.out.println("Number of records in the admin:"+cnt_admin);
    	    
    	    String count_student="Select count(*) from "+name;
    		ResultSet rset = st.executeQuery(count_student);
    	    rset.next();
    	    int cnt_student = rset.getInt(1);
    	    System.out.println("Number of records in the student: "+cnt_student);
    	    
    	    String count_result="Select count(*) from outputtable";
    	    
    		ResultSet r = st.executeQuery(count_result);
    	    r.next();
    	    int cnt_result = r.getInt(1);
    	    System.out.println("Number of records in the admin join student:"+cnt_result);
	    	
    	    String student_id_score_table = "SELECT * FROM student_score WHERE studid = ?";
            PreparedStatement pstmt = con.prepareStatement(student_id_score_table);
            pstmt.setString(1, "'"+name+"'");
            ResultSet result_set = pstmt.executeQuery();
            
            Statement stmt = con.createStatement();
            String check_key = String.format("Select count(*) from student_score where studid='%s'", name);
            ResultSet r_set = stmt.executeQuery(check_key);
           
            if (r_set.next() && r_set.getInt(1) > 0) {
            	if(cnt_admin==cnt_result && cnt_student==cnt_result) {
        	    	int val=10;
        	    	System.out.println("Congrats!!! You got 10 Score");
        	    	String x=qno;
        	    	String student_score = String.format("Insert into student_score (studid, %s) values ('%s', %d) ON DUPLICATE KEY UPDATE %s = %d", qno, name, val, qno, val);
        	    	st.execute(student_score);
        	    	
        	    	
					/*
					 * PreparedStatement student_score =
					 * con.prepareStatement("Update student_score set ? = ? where studid = ?");
					 * student_score.setString(1, qno); student_score.setInt(2, val);
					 * student_score.setString(3, name); student_score.executeUpdate();
					 */
        	    
        	    }
        	    else {
        	    	int val=0;
        	    	String x=qno;
        	    	String student_score = String.format("Insert into student_score (studid, %s) values ('%s', %d) ON DUPLICATE KEY UPDATE %s = %d", qno, name, val, qno, val);
        	    	st.execute(student_score);
					
        	    	System.out.println("Sorry...You got 0 Score");	
        	    	
        	    }
            } 
            else {
            	// String student_score="Insert into student_score "+"(studid)"+" values "+ "('"+name +"')" ;
            	String student_score = String.format("Insert into student_score (studid) values ('%s')", name);
	    		st.execute(student_score);
	    		if(cnt_admin==cnt_result && cnt_student==cnt_result) {
        	    	int val=10;
        	    	System.out.println("Congrats!!! You got 10 Score");
        	    	String x=qno;
        	    	
//        	    	String student_score_d = String.format("Update student_score set %s = %d where studid = '%s';", x, val, name);
//        	    	st.execute(student_score_d);
        	    	
        	    	String student_score_w = String.format("Insert into student_score (studid, %s) values ('%s', %d) ON DUPLICATE KEY UPDATE %s = %d", qno, name, val, qno, val);
        	    	st.execute(student_score_w);
					
        	    
        	    }
        	    else {
        	    	int val=0;
        	    	String x=qno;
        	    	String student_score_z = String.format("Insert into student_score (studid, %s) values ('%s', %d) ON DUPLICATE KEY UPDATE %s = %d", qno, name, val, qno, val);
        	    	st.execute(student_score_z);
					
        	    	System.out.println("Sorry...You got 0 Score");	
        	    	
        	    }
            }
            
            
    	    
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Syntax Error!!!...You got 0 Score");	  
			
		}
		

		}
		
	
}



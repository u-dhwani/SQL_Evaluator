import java.sql.*;
import java.util.*;

public class Algorithm {
	public static void main(String[] args) throws Exception
	{
		String url="jdbc:mysql://localhost:3306/aliens";
		String username="root";
		String password="";
		
		Scanner sc = new Scanner(System.in);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		// This class is responsible to load driver-For using jdbc use driver
		
		Connection con=DriverManager.getConnection(url,username,password);
		
		// search for the method that will give you the instance of connection
		Statement st = con.createStatement();
		
		System.out.println("Enter admin query: ");
		String admin_query = sc.nextLine(); // admin query
		
		String del_admin="Truncate table data";
		st.execute(del_admin);
		
		String admin_ans="Insert into data "+admin_query; // aapdo answer
		
		System.out.println("Enter student query: ");
		String stu_query=sc.nextLine(); // student query
		
		String del_student="Truncate table stdata";
		st.execute(del_student);
		
		String stu_ans="Insert into stdata "+stu_query; // student no answer
		System.out.println(stu_ans);
		
		String del_output="Truncate table outputtable";
		st.execute(del_output);
		
		String output="Select * from stdata natural join data where stdata.studid=data.studid";
		String result="Insert into outputtable "+output;
		
		
		// split query to check for select, insert, etc.
		String admin_arr[] = admin_query.split(" ",2);
		String admin_fw = admin_arr[0];
		
		if(admin_fw.equals("select") || admin_fw.equals("SELECT") || admin_fw.equals("Select")) {
			ResultSet rs = st.executeQuery(admin_query); //DDL, DML, DQL	
			String userData = "";
			while(rs.next()) {
				userData = rs.getInt(1) + " " + rs.getString(2);
				System.out.println(userData);
			}
		}
	
		else if(admin_fw.equals("insert") || admin_fw.equals("INSERT") || admin_fw.equals("Insert")) {
		
			int count = st.executeUpdate(admin_query);
			System.out.println(count + " row(s) affected");
		}
		
		String stu_arr[] = stu_query.split(" ",2);
		String stu_fw = stu_arr[0];
		
		if(stu_fw.equals("select") || stu_fw.equals("SELECT") || stu_fw.equals("Select")) {
			ResultSet rs = st.executeQuery(stu_query); //DDL, DML, DQL	
			String userData = "";
			while(rs.next()) {
				userData = rs.getInt(1) + " " + rs.getString(2);
				System.out.println(userData);
			}
		}
	
		else if(stu_fw.equals("insert") || stu_fw.equals("INSERT") || stu_fw.equals("Insert")) {
		
			int count = st.executeUpdate(stu_query);
			System.out.println(count + " row(s) affected");
		}
		
		
		// storing answers of admin query and student query into tables
		int datatable = st.executeUpdate(admin_ans);
		System.out.println(datatable + " row(s) affected");
		
		int stdatatable = st.executeUpdate(stu_ans);
		System.out.println(stdatatable + " row(s) affected");
		
		int answertable = st.executeUpdate(result);
		System.out.println(answertable + " row(s) affected"); 
		
//		ResultSet rs = st.executeQuery(x); //DDL, DML, DQL
//		String newData = "";
//		while(rs.next()) {
//			newData = rs.getInt(1) + " " + rs.getString(2);
//			System.out.println(newData);
//		}
		
		
		String count_admin="Select count(*) from data";
		ResultSet rs = st.executeQuery(count_admin);
	    rs.next();
	    int cnt_admin = rs.getInt(1);
	    System.out.println("Number of records in the admin:"+cnt_admin);
	    
	    String count_student="Select count(*) from stdata";
		ResultSet rset = st.executeQuery(count_student);
	    rset.next();
	    int cnt_student = rset.getInt(1);
	    System.out.println("Number of records in the student: "+cnt_student);
	    
	    
	    String count_result="Select count(*) from outputtable";
		ResultSet r = st.executeQuery(count_result);
	    r.next();
	    int cnt_result = r.getInt(1);
	    System.out.println("Number of records in the admin join student:"+cnt_result);
	    
	    if(cnt_admin==cnt_result && cnt_student==cnt_result)	System.out.println("Congrats!!! You got 10 Score");
	    else	System.out.println("Sorry...You got 0 Score");	    
	    
		
		st.close();
		con.close();
		
	}
}
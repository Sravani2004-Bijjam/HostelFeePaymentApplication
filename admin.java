import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
@WebServlet("/admin")
public class admin extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    boolean flag= false;
		response.setContentType("text/html");
		PrintWriter pw =response.getWriter();
		int id =Integer.parseInt(request.getParameter("id"));
		String pswd = request.getParameter("pswd");
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","sravani@123");
		 Statement stmt =conn.createStatement();
		 String q = "select * from Admins";
		 ResultSet res = stmt.executeQuery(q);
		 while(res.next()) {
			 if(res.getInt(1)==id && res.getString(2).equals(pswd)) {
				 flag = true;
				 break;
		  }
		}
		}catch(Exception e) {
			 pw.println(e);
		 }
		 if(flag==true) {
			 pw.println("<a href = 'servlet'> <h1>Student Details</h1></a>");
		 }
		 else {
			 pw.println("not login");
			 
		 }
		 
			 
		 }
		 
		 
		
	}
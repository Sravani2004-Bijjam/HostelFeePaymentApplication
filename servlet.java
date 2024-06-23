import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet")
public class servlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw =response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","kalyani@123");
			Statement stmt=conn.createStatement();
			String q = "select * from StudentFees";
			ResultSet res =stmt.executeQuery(q);
			pw.println("<html><body><center><h1>STUDENT FEES DETAILS</h1></center></body></html>");
			pw.println("<html><body><center><table border='5' cellpadding='20' cellspacing='2'><tr><th>Student-Id</th><th>Student-name</th><th>Gender</th><th>Amount</th></tr>>");
			while(res.next()) {
				pw.println("<tr><td>"+res.getInt(1)+"</td>"+"<td>"+res.getString(2)+"</td>"+"<td>"+res.getString(3)+"</td>"+"<td>"+res.getFloat(4)+"</td></tr>");
						
			
			}
			pw.println("</table></center></body></html><br><br>");
			pw.print("<html><body><center>");
			pw.print("<a href='Delete.html'><input type='submit' value='DELETE' style='color:red' style='bgcolor:red'></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			pw.print("<a href='Update.html'><input type='submit' value='UPDATE' style='color:green' background-color='green'></a>");
			pw.print("</center></body></html>");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
			
		}
	

	}
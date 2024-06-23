import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class Delete extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter pw =response.getWriter();
	
	        int id =Integer.parseInt(request.getParameter("id"));
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","kalyani@123");
			String q = "Delete from StudentFees where id= ?";
			PreparedStatement stmt=conn.prepareStatement(q);
			stmt.setInt(1,id);
		    int k = stmt.executeUpdate();
		    if(k>0) {
		       pw.println("<h1 style='color:red'> Deleted successfully</h1>");
		       pw.println("<a href='servlet'><b> Student fees Details</b></a>");
		    }else {
		    	pw.println("<h1 style='color:red'> Invalid! </h1>");
		    	pw.println("<a href='servlet'><b> Student fees Details</b></a>");
		    }
		}catch(Exception e) {
			pw.print(e);
		}
					
			
			
	}

}
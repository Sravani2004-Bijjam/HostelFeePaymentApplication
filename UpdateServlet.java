import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class UpdateServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean flag=false;
		PrintWriter pw =response.getWriter();
		   int id = Integer.parseInt(request.getParameter("id"));
		   float amount =Float.parseFloat(request.getParameter("fees"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","kalyani@123");
			String q = "update StudentFees SET Amount = ?  where id = ?";
			PreparedStatement psmt=conn.prepareStatement(q);
			psmt.setFloat(1,amount);
			psmt.setInt(2, id);
			int k = psmt.executeUpdate();
			if(k>0) {
				flag =true;
		}
		}catch(Exception e) {
			pw.print(e);
		}
		if(flag==true) {
			pw.println("<h1 style='color:green'> your Fees Sucessfully Updated!</h1>");
			pw.println("<a href='servlet'> <b>Student fees Details</b></a>");
	    }else {
	    	pw.println("<h1 style='color:red'> your fees not Updated</h1>");
	    	pw.println("<a href='servlet'><b> Student fees Details</b></a>");
	    }
	}

}
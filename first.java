import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
@WebServlet("/first")
public class first extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw =response.getWriter();
		int id =Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String radio =request.getParameter("radio");
		float fee=Float.parseFloat(request.getParameter("fee"));
		String str =request.getParameter("action");
		switch(str) {
		case  "B":
			 RequestDispatcher dis = request.getRequestDispatcher("main.html");
			 dis.forward(request, response);
	    break;
		case "P":
			 RequestDispatcher dis1 = request.getRequestDispatcher("index.html");
			 dis1.forward(request, response);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			pw.print("loaded");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","kalyani@123");
			pw.print("connected");
			Statement stmt =conn.createStatement();
			pw.println("statement");
			String q="create table StudentFeesDetails(id int Primary key,name varchar(10),gender varchar(10),Amount float)";
			int k =stmt.executeUpdate(q);
			pw.print("created");
			//PreparedStatement stmt =conn.prepareStatement("insert into StudentFees values(?,?,?,?)");	
			//stmt.setInt(1, id);
			//stmt.setString(2,name);
			//stmt.setString(3,radio);
			//stmt.setFloat(4, fee);
			//stmt.executeUpdate();
		}
	catch(Exception e) {
		System.out.println(e);
	}
	break;
		}
	}
}
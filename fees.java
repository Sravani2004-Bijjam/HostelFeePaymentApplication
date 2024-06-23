import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/fees")
public class fees extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int from = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param select 
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean flag=false;
		response.setContentType("text/html");
		PrintWriter pw =response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String pswd = request.getParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/k1","root","kalyani@123");
		    Statement stmt = conn.createStatement();
		    String q ="select * from First";
		    ResultSet res = stmt.executeQuery(q);
		    while(res.next()) {
		    	if(res.getInt(1)==id && res.getString(2).equals(pswd)) {
		    		flag=true;
		    		break;
		    	}
		    }
		}
		
		 catch(Exception e) {
			 pw.println(e);
		 }
		if(flag==true) {
			RequestDispatcher dis=request.getRequestDispatcher("first.html");
			dis.forward(request, response);
		}else {
			pw.println("<h1 style='color:red'>InvalidLogin!</h1>");
		}
		
	}

}
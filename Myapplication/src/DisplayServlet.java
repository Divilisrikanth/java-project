

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	            try{
	                Connection con=DBConnector.DBConnection();
	                Statement st=con.createStatement();
	                
	                ResultSet rs=st.executeQuery("select * from myemp");
	                out.println("<table align=center border=1><tr><th>EmpNo</th><th>EmpName</th><th>EmpSal</th></tr>");
	                while(rs.next())
	                {
	                	//Getting the values from database
	                	
	                    out.println("<tr>");
	                    out.println("<td>"+rs.getString(1)+"</td>");
	                    out.println("<td>"+rs.getString(2)+"</td>");
	                    out.println("<td>"+rs.getString(3)+"</td>");
	                    out.println("<td><a href=Deleteservlet?eno="+rs.getString(1)+">Delete</a></td>");//hyperlink to delete servlet
	                    out.println("<td><a href=Updateservlet?eno="+rs.getString(1)+">Update</a></td>");//hyperlink to update servlet
	                    out.println("</tr>");
	                }
	        }catch(Exception e)
	        {
	            System.out.println(e);
	        }
	   }
}

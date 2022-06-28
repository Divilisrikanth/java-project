

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Updateservlet
 */
@WebServlet("/Updateservlet")
public class Updateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        String eno=request.getParameter("eno");  //reading the from
	        
	        try{
	        Connection con=DBConnector.DBConnection();  //connecting to the database
	        
	        PreparedStatement ps=con.prepareStatement("select * from myemp where eno=?");
	        ps.setString(1, eno);
	        
	        ResultSet rs=ps.executeQuery();
	        rs.next();
	        out.println("<form name=f1 method=get action='UpdateServletDB'><table align=center border=1>");
	        out.println("<tr><td>Empno</td><td><input type=text name='eno' value="+rs.getString(1)+" readonly></td></tr>");
	        out.println("<tr><td>EmpName</td><td><input type=text name='ename' value="+rs.getString(2)+" readonly></td></tr>");
	        out.println("<tr><td>EmpSal</td><td><input type=text name='esal' value="+rs.getString(3)+"></td></tr>");
	        out.println("<tr><td colspan=2 align=center><input type=submit value='update'></td></tr>");
	        out.println("<table></form>");
	        
	     
	        }catch(Exception e)
	        {
	            System.out.println(e);
	        }
	    }
}
	        
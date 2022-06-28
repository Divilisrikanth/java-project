

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Employservlet
 */
@WebServlet("/Employservlet")
public class Employservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
				try{
	        Connection con=DBConnector.DBConnection();  //connecting to the database
	        String username=request.getParameter("username");//reading from
	        
	        
	        PreparedStatement ps=con.prepareStatement("select * from myemp where username=?");
	        ps.setString(1, username);
	        
	        //when employee logins with is username and password this Servlet displays  
	        //is particulars.using href emppwd.html he can create is own password
	        
	        ResultSet rs=ps.executeQuery();
	        rs.next();
	        out.println("<form name=f1 method=post action='servlet2'><table align=center border=1>");
	        out.println("<tr><td>Empno</td><td><input type=text name='eno' value="+rs.getString(1)+" readonly></td></tr>");
	        out.println("<tr><td>EmpName</td><td><input type=text name='ename' value="+rs.getString(2)+" readonly></td></tr>");
	        out.println("<tr><td>EmpSal</td><td><input type=text name='esal' value="+rs.getString(3)+"></td></tr>");
	        out.println("<tr><td>Email</td><td><input type=text name='email' value="+rs.getString(4)+" readonly></td></tr>");
	        out.println("<tr><td>username</td><td><input type=text name='username' value="+rs.getString(5)+" readonly></td></tr>");
	        out.println("<tr><td>password</td><td><input type=password name='password' value="+rs.getString(6)+" readonly></td></tr>");
	        out.println("<td><a href=Emppwd.html>Change password</a></td>");
	        out.println("<td><a href=Employ.html>Sign out</a></td>");
	        
	        out.println("<table></form>");
	        
	     
	        }catch(Exception e)
	        {
	            System.out.println(e);
	        }
	    }
		
	}

	



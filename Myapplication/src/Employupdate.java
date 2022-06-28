

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
 * Servlet implementation class Employupdate
 */
@WebServlet("/Employupdate")
public class Employupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
       
        String password=request.getParameter("password");  //reading the from
        
        try{
        Connection con=DBConnector.DBConnection();  //connecting to the database
        
        //PreparedStatement ps=con.prepareStatement("update myemp set password=? where username=?");
        //This servlet is used to change password of the employee
        
        PreparedStatement ps=con.prepareStatement("select * from myemp where password=?");
        ps.setString(1, password);
        
        ResultSet rs=ps.executeQuery();
        rs.next();
        out.println("<form name=f1 method=Post action='EmpupdateDB'><table align=center border=1>");
        out.println("<tr><td>Empno</td><td><input type=text name='eno' value="+rs.getString(1)+" readonly></td></tr>");
        out.println("<tr><td>EmpName</td><td><input type=text name='ename' value="+rs.getString(2)+" readonly></td></tr>");
        out.println("<tr><td>password</td><td><input type=password name='password' value="+rs.getString(6)+"></td></tr>");
        out.println("<tr><td colspan=2 align=center><input type=submit value='update'></td></tr>");
        out.println("<table></form>");
        
     
        }catch(Exception e)
        {
            System.out.println(e);
        }
    
		
	}

}

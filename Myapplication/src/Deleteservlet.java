

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Deleteservlet
 */
@WebServlet("/Deleteservlet")
public class Deleteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        
	        String eno=request.getParameter("eno");  //reading the from
	        
	        try{
	        //connecting to the database
	        	
	        Connection con=DBConnector.DBConnection(); 
	        
	        //deleting the values in the database using eno as
	        //reading values from delete.html
	        
	        PreparedStatement ps=con.prepareStatement("delete from myemp where eno=?");
	        ps.setString(1, eno);
	        
	        ps.executeUpdate();
	        
	        //redirecting to display servlet
	        
	        response.sendRedirect("DisplayServlet");
	     
	        }catch(Exception e)
	        {
	            System.out.println(e);
	        }
	    }
}

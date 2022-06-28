

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServletDB
 */
@WebServlet("/UpdateServletDB")
public class UpdateServletDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String eno=request.getParameter("eno");  //reading the from
        String ename=request.getParameter("ename");  //reading the from
        String esal=request.getParameter("esal");  //reading the from
        
        try{
        Connection con=DBConnector.DBConnection();  //connecting to the database
        
        PreparedStatement ps=con.prepareStatement("update myemp set esal=? where eno=?");
        ps.setString(2, eno);
        ps.setString(1, esal);
        ps.executeUpdate();
        response.sendRedirect("DisplayServlet");
     
        }catch(Exception e)
        {
            System.out.println(e);
        }
	}
}
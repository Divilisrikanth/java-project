

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class Insertservlet
 */
@WebServlet("/Insertservlet")
public class Insertservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	 String eno=request.getParameter("eno");  //reading the from
     String ename=request.getParameter("ename");
     String esal=request.getParameter("esal");
     String email=request.getParameter("email");
     String username=request.getParameter("username");
     String password=request.getParameter("password");
    try{
    Connection con=DBConnector.DBConnection();  //connecting to the database
    
    PreparedStatement ps=con.prepareStatement("insert into myemp values(?,?,?,?,?,?)");
    ps.setString(1, eno);
    ps.setString(2, ename);
    ps.setString(3, esal);
    ps.setString(4, email);
    ps.setString(5, username);
    ps.setString(6, password);
    ps.executeUpdate();
    response.sendRedirect("index.html");
    
    }catch(Exception e)
    {
        System.out.println(e);
    }
  }
}

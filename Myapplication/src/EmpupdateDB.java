

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpupdateDB
 */
@WebServlet("/EmpupdateDB")
public class EmpupdateDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String eno=request.getParameter("eno");  //reading the from
        String ename=request.getParameter("ename");  //reading the from
        String password=request.getParameter("password");  //reading the from
        
        try{
        Connection con=DBConnector.DBConnection();  //connecting to the database
        
        PreparedStatement ps=con.prepareStatement("update myemp set password=? where eno=?");
        ps.setString(2, eno);
        ps.setString(1, password);
        ps.executeUpdate();
        response.sendRedirect("Employ.html");
     
        }catch(Exception e)
        {
            System.out.println(e);
        }
	}

}

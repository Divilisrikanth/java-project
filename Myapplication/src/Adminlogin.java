

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Adminlogin
 */
@WebServlet("/Adminlogin")
public class Adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            String un=request.getParameter("username");//reading the values from Admin.html page
            String pwd=request.getParameter("password");//reading the values from admin.html page
            
           // using if else condition to verify the
           //values if User name and password matches 
           //it will redirect to next page that is Adminpage.htm
            if(un.equals("admin") && pwd.equals("admin"))
            	                                          
            	                                         
            {
                response.sendRedirect("Adminpage.html");
            }
            else
            {
                RequestDispatcher rd=request.getRequestDispatcher("Admin.html");
                rd.include(request, response);
                out.println("<center><h3>Username Password not match</h3></center>");
            }
    }
}



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet2
 */
@WebServlet("/servlet2")
public class servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
        	Connection con=DBConnector.DBConnection();
            Statement stmt = con.createStatement();
            String sql=("select * from myoffice.myemp where username = '"+username+"' and password = '"+password+"'");
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                RequestDispatcher rd = request.getRequestDispatcher("Employservlet");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("Employ.html");
                rd.include(request, response);
                out.println("<center><font color=red>Username/password not match");
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
	}
}

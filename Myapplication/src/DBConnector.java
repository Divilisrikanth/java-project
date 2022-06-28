import java.sql.*;

public class DBConnector {
	 public static Connection DBConnection() throws Exception
	    {
	        
	        Class.forName("com.mysql.jdbc.Driver");
	        System.out.println("Registered");

	        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myoffice","root","M@1234");
	        return con;
	    }      
}
	 

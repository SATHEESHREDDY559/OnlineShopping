import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 */

/**
 * @author Satheesh
 *
 */
public class DriverConnection {
	
public static Connection getConnection() throws Exception{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	
	return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Bejjanki");
	
}
	
	
	
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO{
	public boolean validate(String uname, String pass) throws SQLException{
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			con=DriverConnection.getConnection();
			stmt=con.createStatement();
			String query="select * from customer where name=\'"+uname+"\' and password=\'"+pass+"\'";
			rs =stmt.executeQuery(query);
		
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		 return rs.next();
	}
}
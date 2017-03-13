import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 
 */

/**
 * @author Satheesh
 *
 */
public class ProductsDAO {
	
	public Collection getProducts(){
		
	try{
		Connection con=DriverConnection.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from products");
		ArrayList products= new ArrayList();
		while(rs.next()){
			Product p= new Product();
			p.setCode(rs.getString(1));
			p.setName(rs.getString(2));
			p.setQty(rs.getDouble(3));
			products.add(p);
		}
		return products;
	}catch(SQLException e){
		e.printStackTrace();
		return null;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	
		
	}

}



import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetProductServlet
 */
@WebServlet("/GetProductServlet")
public class GetProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ProductsDAO productdao=new  ProductsDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession hs=request.getSession(false);
		if(hs==null){
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("home.html");
			requestDispatcher.forward(request, response);
			return;
		}
				String uname=(String)hs.getAttribute("uname");
				response.setContentType("text/html");
				PrintWriter pw=response.getWriter();
				pw.println("<html><head>");
				pw.println("<title>My Online Shopping Site</title>");
				pw.println("</head><body>");
				pw.println("<table width='100%' height='90%' border='1'>");
				pw.println("<tr align='center'>");
				pw.println("<td height='39' colspan='2'><strong><font size='5'>Online Shopping </font></strong></td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<td width='5%' height='500%' valign='top'><p >&nbsp;</p>");
				pw.println("<blockquote>");
				pw.println("<p><a href='"+response.encodeURL("getProducts")+"'>View Product</a></p>");
				pw.println("<p><a href='"+response.encodeURL("getCart")+"'>View Cart</a></p>");
				pw.println("<p><a href='"+response.encodeURL("logout")+"'>Logout</a></p>");
				pw.println("</blockquote></td>");
				pw.println("<td height='89%' colspan='2' valign='top'><strong><font size='3'>Welcome, "+uname+" </font></strong>");
				pw.println("<form action='"+response.encodeURL("addProducts")+"'>");
				pw.println("<table width='100%' border='1'>");
				pw.println("</tr>");
				pw.println("<th width='10%'>Check</th>");
				pw.println("<th width='20%'> Product Code</th>");
				pw.println("<th width='25%'>Product Name</th>");
				pw.println("<th width='20%'> Available Qty</th>");
				pw.println("<th width='25%'>Required Qty</th>");
				pw.println("</tr>");
				Collection products=productdao.getProducts();
				if(products==null){
					pw.println("<tr><td colspan='5' align='center'>");
					pw.println("No products availble");
					pw.println("</td></tr>");
				}
				else{
					
					Iterator iterator=products.iterator();
					while (iterator.hasNext()) {
						Product p = (Product) iterator.next();
						pw.println("<tr>");
						pw.println("<td align='center'>");
						pw.println("<input type='checkbox' name='products'value='"+p.getCode()+"'/>");
						pw.println("<input type='hidden' name='"+p.getCode()+"name' value='"+p.getName()+"'/></td>");
						pw.println("<td>"+p.getCode()+"</td>");
						pw.println("<td>"+p.getName()+"</td>");
						pw.println("<td>"+p.getQty()+"</td>");
						pw.println("<td><input type='text' name='"+p.getCode()+"'</td>");
						pw.println("</tr>");
					}
					
				}
				pw.println("</table>");
				pw.println("</br><center>");
				pw.println("<input type='submit' value='Add Products to Cart'/>");
				pw.println("</center>");
				pw.println("</td>");
				pw.println("</tr>");
				
				pw.println("<tr align='center'");
				pw.println("<td colspan='2' ><em>&copy; Copyrights 2015-20</em></td>");
				pw.println("</tr>");
				pw.println("</table>");
				pw.println("</body></html>");
				pw.flush();
				pw.close();
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

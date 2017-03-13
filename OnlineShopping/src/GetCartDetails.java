

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
 * Servlet implementation class GetCartDetails
 */
@WebServlet("/GetCartDetails")
public class GetCartDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCartDetails() {
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
				pw.println("<td width='12%' height='500%' valign='top'><p >&nbsp;</p>");
				pw.println("<blockquote>");
				pw.println("<p><a href='"+response.encodeURL("getProducts")+"'>View Product</a></p>");
				pw.println("<p><a href='"+response.encodeURL("getCart")+"'>View Cart</a></p>");
				pw.println("<p><a href='"+response.encodeURL("logout")+"'>Logout</a></p>");
				pw.println("</blockquote></td>");
				pw.println("<td width='82%' colspan='2' valign='top'><strong><font size='5'>Welcome, "+uname+" </font></strong>");
				pw.println("<center>Your cart contains the following products");
				pw.println("<table width='100%' border='1'>");
				pw.println("<tr>");
				
				pw.println("<th width='20%'> Product Code</th>");
				pw.println("<th width='25%'>Product Name</th>");
				pw.println("<th width='20%'> Qty</th>");
			
				pw.println("</tr>");
				Collection products=(Collection)hs.getAttribute("products");
				if(products==null){
					pw.println("<tr><td colspan='5' align='center'>");
					pw.println("you have not yet added products to cart");
					pw.println("</td></tr>");
				}
				else{
					
					Iterator iterator=products.iterator();
					while (iterator.hasNext()) {
						Product p = (Product) iterator.next();
						pw.println("<tr>");
						pw.println("<td>"+p.getCode()+"</td>");
						pw.println("<td>"+p.getName()+"</td>");
						pw.println("<td>"+p.getQty()+"</td>");
						
						pw.println("</tr>");
					}
					
				}
				pw.println("</table>");				
				pw.println("</td>");
				pw.println("</tr>");
				pw.println("</center>");
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

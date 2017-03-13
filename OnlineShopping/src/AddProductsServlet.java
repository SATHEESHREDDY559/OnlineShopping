

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddProductsServlet
 */
@WebServlet("/AddProductsServlet")
public class AddProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;      
   
    public AddProductsServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			HttpSession hs=request.getSession(false);
	if(hs==null){
		RequestDispatcher rd =request.getRequestDispatcher("home.html");
		rd.forward(request, response);
		return;
	}
	String name=(String)hs.getAttribute("uname");
	ArrayList products=(ArrayList)hs.getAttribute("products");
	if(products==null){
		products= new ArrayList();
		hs.setAttribute("products",products);
		
	}
	String pcodes[]=request.getParameterValues("products");
	for(int i=0; i<pcodes.length; i++){
		if(request.getParameter(pcodes[i]).equals("")){
			continue;
			}
		Product p=new Product();
		p.setCode(pcodes[i]);
		int j=products.indexOf(p);
		if(j!=-1){
			p=(Product)products.get(j);
			p.qty+=Double.parseDouble(request.getParameter(pcodes[i]));
		}
		else{
			p.setName(request.getParameter(pcodes[i]+"Name"));
			p.setQty(Double.parseDouble(request.getParameter(pcodes[i])));
			products.add(p);
		}
		
	}
	response.setContentType("text/html");
	PrintWriter pw=response.getWriter();
	pw.println("<html><head>");
	pw.println("<title>My Online Shopping Site</title>");
	pw.println("</head><body>");
	pw.println("<table width='100%' height='90%' border='2'>");
	pw.println("<tr align='center'>");
	pw.println("<td height='39' colspan='2'><strong><font size='5'>Online Shopping </font></strong></td>");
	pw.println("</tr>");
	pw.println("<tr>");
	pw.println("<td width='10%' height='500%' valign='top'><p >&nbsp;</p>");
	pw.println("<blockquote>");
	pw.println("<p><a href='"+response.encodeURL("getProducts")+"'>View Product</a></p>");
	pw.println("<p><a href='"+response.encodeURL("getCart")+"'>View Cart</a></p>");
	pw.println("<p><a href='"+response.encodeURL("logout")+"'>Logout</a></p>");
	pw.println("</blockquote></td>");
	pw.println("<td height='' colspan='2' valign='top'><strong><font size='5'>Welcome, "+name+" </font></strong>");
	pw.println("Products are added successfully");
	pw.print("</td></tr>");
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



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserHomeServlet
 */
@WebServlet("/UserHomeServlet")
public class UserHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserHomeServlet() {
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
				pw.println("<td width='15%' height='400%' valign='top'><p >&nbsp;</p>");
				pw.println("<blockquote>");
				pw.println("<p><a href='"+response.encodeURL("getProducts")+"'>View Product</a></p>");
				pw.println("<p><a href='"+response.encodeURL("getCart")+"'>View Cart</a></p>");
				pw.println("<p><a href='"+response.encodeURL("logout")+"'>Logout</a></p>");
				pw.println("</blockquote></td>");
				pw.println("<td  colspan='2'  valign='top'><strong><font size='3'>Welcome, "+uname+" </font></strong></td>");
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

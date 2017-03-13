

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserDAO ud;
		String uname=request.getParameter("name");
		String pass=request.getParameter("password");
		
		
		ud=new UserDAO();
		try {
			if(ud.validate(uname, pass)){
				HttpSession hs=request.getSession();
				hs.setAttribute("uname", uname);
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("UserHomeServlet");
				requestDispatcher.forward(request, response);
				
			}
			else{
				PrintWriter printWriter=response.getWriter();
				printWriter.print("invalid uname and password");
				RequestDispatcher rd=request.getRequestDispatcher("home.html");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

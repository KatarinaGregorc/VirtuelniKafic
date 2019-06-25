package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.logInDao;
import model.Rola;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "Servlet za logovanje", urlPatterns = { "/LoginServlet" })
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName= request.getParameter("userName");
		String password= request.getParameter("password");
		
		
		
		logInDao   logInDao = new logInDao();
		
		User user=new User();
		
		
		boolean proveriUsera= logInDao.daLiPostojiUserUbazi(userName);
		
		if(proveriUsera) {
			
			boolean proveriPassword=logInDao.daLiPasswordOdgovaraUser(userName, password);
			
		if(proveriPassword) {
	user=logInDao.vratiUsera(userName);
		if(user.getRola().equals(Rola.ADMINISTRATOR));
		
	response.sendRedirect("view/administraror.jsp");
	
	
		}else {
			response.sendRedirect("view/user.jsp");
		}	
			
			
			//nastavi dalje
		}else {
			
			response.sendRedirect("login.html");
		
		}
		
		
		
		doGet(request, response);
	}

}

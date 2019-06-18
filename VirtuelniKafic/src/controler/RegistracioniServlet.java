package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Validacija.ValidacijaZaRegistraciju;

/**
 * Servlet implementation class RegistracioniServlet
 */
@WebServlet(description = "ovo je servlet koji regulise registraciju  user", urlPatterns = { "/PutanjaservletazaRegistraciju" })
public class RegistracioniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public RegistracioniServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Pozdrav iz servleta");
		
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		String repeatPassword =request.getParameter("repeatPassword");
		System.out.println("Vas username je "+username);
		System.out.println("Vas password je"+ password);
		System.out.println("Vas repa je"+ repeatPassword);
		
		
		boolean provera=ValidacijaZaRegistraciju.proveraPassworda(password, repeatPassword);
		if(provera) {
			//upisi usera u bazu-tu ce ustvari upisati usera
			response.sendRedirect("index.html");
		}else {
			response.sendRedirect("Registracija.html");
		}
		
		
		
		//if(password.equals(repeatPassword));
		//upisi usera u bazu
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

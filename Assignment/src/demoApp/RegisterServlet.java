package demoApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demoDB.Methods;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String[] fields = new String[5];
		
		fields[0] = request.getParameter("fname");
		fields[1] = request.getParameter("lname");
		fields[2] = request.getParameter("email");
		fields[3] = request.getParameter("phone");
		fields[4] = request.getParameter("password");
		
	    try{
			
			Methods.makeConnection();
			Methods.insert("users", fields);
			out.println("<h2>Registered successfully</h2>");
			out.println("Please <a href=\"Login.html\">login</a> to continue");
		}
		catch(SQLException e){
			out.print(e.getMessage());		
		}
	    catch(ClassNotFoundException e){
	    	out.print(e.getMessage());
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

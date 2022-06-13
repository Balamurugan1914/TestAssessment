package TestServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updateServlet2
 */
@WebServlet("/updateServlet2")
public class updateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		
		pw.print("<h>UPDATE EMPLOYEE DETAILS</h><br><br>");
		
		pw.println("<table border = '1' width = 50% >");
		pw.println("<form >");
		pw.println("<tr><td>Employee ID</td> <td><input type='number' name='id'></td><td>Employee Name</td> <td><input type='text' "
				+ "name='name'></td><td>Employee Age</td> <td><input type='number' name='age'></td><td>Employee Designation</td> <td><input type='text' "
				+ "name='designation'></td><td>Employee phoneNumber</td> <td><input type='number' name='phonenumber'></td>"
				+ "<td>Employee Salary</td> <td><input type='number' name='salary'></td></tr>");
		pw.print("<tr><td><input type ='submit' value='Edit & Save' formaction='UpdateServlet'></td></tr>");
		pw.println("</form >");
     pw.println("</table"); 
		
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

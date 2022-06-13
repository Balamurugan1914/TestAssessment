package TestServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String Designation = request.getParameter("designation");
		long phoneNumber = Long.parseLong(request.getParameter("phonenumber"));
		int Salary = Integer.parseInt(request.getParameter("salary"));

		Employee em = new Employee();

		em.setEmpid(id);
		em.setName(name);
		em.setAge(age);
		em.setDesignation(Designation);
		em.setPhoneNumberl(phoneNumber);
		em.setSalary(Salary);

		int status = EmployeeDb.Insert(em);

		if (status > 0) {

			pw.println("Created succesfully");
			RequestDispatcher rd = request.getRequestDispatcher("ViewServlet");
			rd.include(request, response);
		} else {

			pw.println("Sorry!! Unable to insert");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

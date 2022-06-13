package TestServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
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
		
		pw.print("<a href= 'Employee.html'>Back</a><br><br>");
		
		
		pw.print("<h>VIEW EMPLOYEE DETAILS</h><br><br>");
		List<Employee> li = EmployeeDb.getAllDetails();
		
		pw.println("<table border = '1' width = 100% >");
		pw.println("<tr><td>Id</td><td>Name</td><td>Age</td><td>Designation</td><td>PhoneNumber</td><td>Salary</td><td>Edit</td></tr>");
		for(Employee e : li)
		pw.println("<tr><td>"+e.getEmpid()+"</td><td>"+e.getName()+"</td><td>"+e.getAge()+"</td><td>"+e.getDesignation()+"</td><td>"+e.getPhoneNumberl()+"</td><td>"+e.getSalary()+"</td>"
				+ "<td><a href='updateServlet2?id="+e.getEmpid()+"'>Edit</a></td><tr>");
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

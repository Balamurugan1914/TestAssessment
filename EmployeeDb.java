package TestServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.*;

public class EmployeeDb {

	public static final String DB_DRIVER_CLASS = "org.postgresql.Driver";
	private static String DB_URL = "jdbc:postgresql://localhost:5432/vastpro";
	private static String DB_USER = "postgres";
	private static String DB_PASSWORD = "postgres";
	private static String CREATE = "insert into employee3(empid,name,age,designation,phonenumber,salary)values(?,?,?,?,?,?)";
	private static String UPDATE = "update employee3 set salary = ?,designation = ? where empid= ?";
	private static String DELETE = "delete from employee3 where empid= ?";
	private static String DISPLAY = "select * from employee3 ";
	private static String Display2 = "select  from employee3 where salary <= 300000; ";

	public static Connection getConnection() {

		Connection c = null;
		try {

			Class.forName(DB_DRIVER_CLASS);
			c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			System.out.println("Connection has been successfull");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Errored connection");
		}

		return c;

	}

	public static int Insert(Employee e) {

		int status = 0;
		try {
			Connection c = EmployeeDb.getConnection();
			PreparedStatement ps = c.prepareStatement(CREATE);
			ps.setInt(1, e.getEmpid());
			ps.setString(2, e.getName());
			ps.setInt(3, e.getAge());
			ps.setString(4, e.getDesignation());
			ps.setLong(5, e.getPhoneNumberl());
			ps.setInt(6, e.getSalary());

			status = ps.executeUpdate();
			c.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return status;

	}

	public static int Update(Employee e) {

		int status = 0;
		try {
			Connection c = EmployeeDb.getConnection();
			PreparedStatement ps = c.prepareStatement(UPDATE);

			ps.setInt(1, e.getSalary());
			ps.setString(2, e.getDesignation());
			ps.setInt(3, e.getEmpid());

			status = ps.executeUpdate();
			c.close();
			

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return status;

	}

	public static int Delete(int id) {

		int status = 0;
		try {
			Connection c = EmployeeDb.getConnection();
			PreparedStatement ps = c.prepareStatement(DELETE);

			ps.setInt(1, id);

			status = ps.executeUpdate();
			c.close();
			

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return status;

	}

	public static List<Employee> getAllDetails() {

		List<Employee> li = new ArrayList<Employee>();

		try {

			Connection c = EmployeeDb.getConnection();
			PreparedStatement ps = c.prepareStatement(DISPLAY);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee e = new Employee();

				e.setEmpid(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setAge(rs.getInt(3));
				e.setDesignation(rs.getString(4));
				e.setPhoneNumberl(rs.getLong(5));
				e.setSalary(rs.getInt(6));

				li.add(e);
				c.close();
				

			}
		} catch (Exception e) {

			e.printStackTrace();

		}

		return li;

	}
	public static List<Employee> getEmpSalary() {

		List<Employee> li = new ArrayList<Employee>();

		try {

			Connection c = EmployeeDb.getConnection();
			PreparedStatement ps = c.prepareStatement(DISPLAY);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee e = new Employee();

				
				e.setSalary(rs.getInt(6));

				li.add(e);
				c.close();
				

			}
		} catch (Exception e) {

			e.printStackTrace();

		}

		return li;

	}

	

	
	

}

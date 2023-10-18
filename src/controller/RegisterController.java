package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (PrintWriter out = response.getWriter();) {

			String username = request.getParameter("uname");
			String password = request.getParameter("pwd");
			String mailid = request.getParameter("mail");
			String mobnum = request.getParameter("mob");

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/samplecrud", "root", "admin");
			Statement st = con.createStatement();

			int resp = st.executeUpdate("insert into register(username,password,mailid,mobilenumber) values ('"
					+ username + "','" + password + "','" + mailid + "','" + mobnum + "')");

			if (resp == 1) {
				out.println("inserted Sucessfully");
				
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

}

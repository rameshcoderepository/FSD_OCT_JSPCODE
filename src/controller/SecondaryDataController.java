package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SecondaryDataController")
public class SecondaryDataController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (PrintWriter out = response.getWriter();) {
			
			response.setContentType("text/html");

			String address = request.getParameter("add");
			String mobnum = request.getParameter("mob");

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysq://localhost:3306/samplecrud", "root", "admin");
			Statement st = con.createStatement();

			int resp = st.executeUpdate(
					"insert into secondarydata(mobilenumber, address) values ('" + mobnum + "','" + address + "')");

			if (resp == 1) {
				out.println("inserted Sucessfully");
				RequestDispatcher req = request.getRequestDispatcher("/AdminHome.jsp");
				req.include(request, response);

			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

}

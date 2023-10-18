package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		try (PrintWriter out = response.getWriter();) {

			String username = request.getParameter("uname");
			String password = request.getParameter("pwd");

			if ("admin".equals(username) && "admin123".equals(password)) {
				out.println("welcomea admin" + username);

				// Cookie ck=new Cookie("user",username);//creating cookie object
				// response.addCookie(ck);

				HttpSession session = request.getSession();
				session.setAttribute("pname", username);

				RequestDispatcher req = request.getRequestDispatcher("/AdminHome.jsp");
				req.include(request, response);

			} else {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/samplecrud", "root", "admin");
				Statement st = con.createStatement();

				ResultSet res = st.executeQuery("select * from register");

				int flag = 0;
				while (res.next()) {

					String dbUser = res.getString("username");
					String dbPass = res.getString("password");

					if (dbUser.equals(username) && dbPass.equals(password)) {
						out.println("sucess");
						flag = 1;
						RequestDispatcher req = request.getRequestDispatcher("/UserHome.jsp");
						req.forward(request, response);
					}
				}

				if (flag == 0) {
					out.println("sorry username & password incorrect");
					/*
					 * RequestDispatcher req = request.getRequestDispatcher("/index.jsp");
					 * req.include(request, response);
					 */

					response.sendRedirect("http://google.com");
				}
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

}

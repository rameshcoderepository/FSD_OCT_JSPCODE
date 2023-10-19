<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String mob = request.getParameter("mobnum");
		String name = request.getParameter("name");
		String address = request.getParameter("address");

		System.out.print(mob + " " + name + " " + address);
	%>

	<form action="#" method="post">
		<table align="center">
			<tr>
				<td>MObileNumber</td>
				<td><input type="text" id="uname" name="uname" value="<%=mob%>"
					readonly="readonly"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" id="pwd" name="pwd" value="<%=name%>"></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" id="pwd" name="pwd" value="<%=address%>"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit"></td>
			</tr>
			<tr>
				<td></td>
				<td><a href="signup.jsp">SignUp</a></td>
			</tr>
		</table>
	</form>


</body>
</html>
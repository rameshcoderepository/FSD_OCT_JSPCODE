<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
body {
	background: gray;
}
</style>
<script type="text/javascript">
	function myFunction() {

		var username = document.getElementById("uname").value; // Find the element 
		var pass = document.getElementById("pwd").value;

		if (username == "") {
			alert("Please enter the username");
			return false;
		}
		if (pass == "") {
			alert("Please enter the password");
			return false;
		}
	}
</script>
</head>
<body>
	<form action="RegisterController" method="post"
		onsubmit="return myFunction()">
		<table align="center">
			<tr>
				<td>userName</td>
				<td><input type="text" id="uname" name="uname"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" id="pwd" name="pwd"></td>
			</tr>
			<tr>
				<td>Maild _Id</td>
				<td><input type="text" id="mail" name="mail"></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td><input type="text" id="mob" name="mob"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register"></td>
			</tr>
			
		</table>
	</form>

</body>
</html>
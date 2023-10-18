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
		/* Cookie ck[] = request.getCookies();
		for (int i = 0; i < ck.length; i++) {
			out.print("<br>" + ck[i].getName() + " " + ck[i].getValue());//printing name and value of cookie  
		}
		*/

		String value = (String) session.getAttribute("pname");
		
		out.println(value);
	%>

</body>
</html>
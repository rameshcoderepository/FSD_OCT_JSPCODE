<%@page import="service.DbService"%>
<%@page import="bean.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="2px" align="center">

		<tr>
			<th>MobileNumber</th>
			<th>Name</th>
			<th>Address</th>
		</tr>


		<%
			List<PrimaryData> primaryResponse = DbService.getPrimaryData();
			List<SecondaryData> secondaryResponse = DbService.getSecondaryData();

			Map<String, PrimaryData> primaryMap = new HashMap<String, PrimaryData>();

			if (!primaryResponse.isEmpty()) {

				for (PrimaryData primaryData : primaryResponse) {

					primaryMap.put(primaryData.getMobilenumber(), primaryData);

				}
			}

			if (!secondaryResponse.isEmpty()) {

				for (SecondaryData secondaryData : secondaryResponse) {

					PrimaryData primaryData = primaryMap.get(secondaryData.getMobilenumber());

					System.out.println(primaryData.getMobilenumber() + " " + primaryData.getName() + " "
							+ secondaryData.getAddress());
		%>

		<tr>
			<td><%=primaryData.getMobilenumber()%></td>
			<td><%=primaryData.getName()%></td>
			<td><%=secondaryData.getAddress()%></td>
			<td><a
				href="Updatedetails.jsp?mobnum=<%=primaryData.getMobilenumber()%>&name=<%=primaryData.getName()%>&address=<%=secondaryData.getAddress()%>">Update
					Details</a></td>


		</tr>


		<%
			}
			}
		%>
	</table>
</body>
</html>
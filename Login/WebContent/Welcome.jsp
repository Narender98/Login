<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="${pageContext.request.contextPath}/css/RegisterMessage.css" rel="stylesheet" >
</head>
<body>

		<%
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //Http 1.1
			
			if(session.getAttribute("Username")==null)
			{
				response.sendRedirect("Login.jsp");
			}
		%>

		
		<div class="container">
			<h3>WELCOME</h3>
			<h4>${Username}</h4>
		</div>
		

</body>
</html>
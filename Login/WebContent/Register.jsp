
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>

<link href="${pageContext.request.contextPath}/css/Register1.css" rel="stylesheet" >

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body class="mybody">
		
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //Http 1.1
	%>

	 <form class="nk" action="Register" method="post">
	 		<h1>Register Here</h1>
	 		<input type="text" name="Ruid" placeholder="User ID" required="required">
	  		<input type="text" name="Runame" placeholder="Username" required="required">
	 		<input type="password" name="Rpass1" placeholder="Password" required="required">
	 		<input type="password" name="Rpass2" placeholder="Confirm Password" required="required">
	 		<input type="submit" value="Register">
	 		
	 		<div class="error">
	 			${errorMessageRegister}
	 		</div>
	 </form>
</body>
</html>
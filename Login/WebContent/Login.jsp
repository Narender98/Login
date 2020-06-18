<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

<link href="${pageContext.request.contextPath}/css/Login2.css" rel="stylesheet" >


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

	<form class="box" action="Login" method="post">
		<h1>Login</h1>
		
		<input type="text" name="Luid" placeholder="User ID" required="required">
		<input type="password" name="Lpass" placeholder="Password" required="required">
		<input type="submit" value="Login">
	
		<div class="bottom-text">
			Don't have account? <a href="Register.jsp">Sign Up</a>
		</div>
		
		<div class="error">
			${errorMessageLogin}
		</div>
	</form>
</body> 
</html>

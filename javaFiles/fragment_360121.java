<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>User Log in</title>
<%@ include file="PageHeader.html" %>
</head>
<body>
<form action = "LoginServlet" method="POST">
<h3>Sign In</h3><br>
Email: <input type="text" name="email" required value="${email}"><br>
Password: <input type="password" name="pass" required value="${pass}"><br>
<div style="color: #FF0000;">${errorMessage}</div><br>
<input type="submit" name="submit" value="Sign in" id="sButton">

</form>
</body>
</html>
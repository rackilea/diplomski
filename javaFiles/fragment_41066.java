<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<c:if test="${failed==1}">  
    <font color="red">
    Authentication failed. Wrong email/password.
    </font>
</c:if>

<form action="<c:url value='/login />'" method="POST">
    <label> E-mail </label>
    <input type="email" name="username" required><br>
    <label> Password </label>
    <input type="password" name="password" required><br>
    <input type="submit" value="Sign in"><br>
</form>
</body>
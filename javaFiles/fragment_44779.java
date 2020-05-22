<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome to Spring Web MVC project</title>
</head>

<body>
<h1>Register Success!</h1>
<table>
    <tr>
        <td>User Name</td>
        <td><c:if test="${not empty username}"> ${username}</c:if></td>
    </tr>
    <tr>
        <td>Password</td>
        <td><c:if test="${not empty password}">${password}</c:if></td>
    </tr>
    <tr>
        <td>Email</td>
        <td><c:if test="${not empty email}">${email}</c:if></td>
    </tr>
    <tr>
        <td>BirthDate (mm/dd/yyyy)</td>
        <td><c:if test="${not empty birthDate}">${birthDate}</c:if></td>
    </tr>
    <tr>
        <td>Profession</td>
        <td><c:if test="${not empty profession}">${profession}</c:if></td>
    </tr>
</table>
</body>
</html>
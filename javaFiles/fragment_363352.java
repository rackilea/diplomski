<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:url value="/spring/login" var="loginUrl"/>
<form method="post" action="${loginUrl}">
    usu&aacute;rio: <input type="text" name="login" size=20> <br/>
    senha: <input type="password" name="senha" size=20> <br/>
    <input type="submit" value="entrar"> <br/>
</form>

</body>
</html>
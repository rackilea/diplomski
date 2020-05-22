<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2 style="color: red; text-align: center">There are something error! Please come back!</h2>
<%
    request.getSession().removeAttribute("anAttribute");
%>
</body>
</html>
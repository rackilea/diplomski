<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body> 
<% SomeVariableClass var = SomeVariableClass.getInstance()%>
<div id="var"><%=var.getValue()%></div>
</body>
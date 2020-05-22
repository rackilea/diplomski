<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    String name = request.getParameter("realName");
  %>
    Here's the param "realName": <%=name%>
  </body>
</html>
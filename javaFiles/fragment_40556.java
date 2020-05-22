<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Favorites: root</title>
</head>
<body>
<p>Add a User</p>
<spring:form action="/tdd/addUser" method="post" modelAttribute="user">

//changed to basic html inputfields

  <input name="newusername" type="text" />
  <input name="newpassword" type="password" />
  <input type="submit" value="ADD USER" name="Add user">

</spring:form>
</body>
</html>
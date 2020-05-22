<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <p>Hello,
    <c:choose>
    <c:when test="${not empty param.name}">
      <c:out value="${param.name}" />.
    </c:when>
    <c:otherwise>
      stranger.
    </c:otherwise>
    </c:choose>
  </p>
  <form method="post">
    <label>Please enter your name</label>
    <input id="name" name="name" type="text"/>
    <input id="marker" name="marker" type="hidden" 
        value="<c:out value="${sessionScope.marker}"/>"/>
    <button type="submit">OK</button>
  </form>
</body>
</html>
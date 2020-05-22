<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<form:form method="POST" modelAttribute="person">
Birth day: <form:input path="birthDay" /><form:errors path="birthDay" />
<br />
<input type="submit" value="Submit" />
</form:form>
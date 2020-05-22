<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>

     <form:form action="/index" method="POST">
     <div class="form-group">

     <td><textarea class="form-control" name="textForm">${text1}</textarea>   
     <input type="submit" value="Submit">
     <textarea name="textFin">${textFinal}</textarea></td>
     </form:form>
    </div>


</body>
</html>
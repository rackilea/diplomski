<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        Environment:<select name="Environment">
                        <option></option>
            <c:forEach var="item" items="${ListEnvironment}">
                <option>
                    <c:out value="${item.string1}"/>
                </option>
            </c:forEach>
        </select>
    </body>
</html>
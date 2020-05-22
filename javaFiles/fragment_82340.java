<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table id="messages" border="1">
            <tr>
                <th>Message</th>
                <th>Type</th>
            </tr>

            <c:forEach var="msg" items="${requestScope.messageList}">
                <tr>
                    <td>${msg[0]}</td>
                    <td>${msg[1]}</td>
                </tr>
            </c:forEach>    
        </table>     
    </body>
</html>
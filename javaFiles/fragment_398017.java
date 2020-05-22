<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

...

<table>
    <c:forEach items="${persons}" var="person">
        <tr>
            <td>${person.name}</td>
            <td>${person.email}</td>
            <td>${person.age}</td>
        </tr>
    </c:forEach>
</table>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${map}" var="entry">
    Key = ${entry.key}, values = 
    <c:forEach items="${entry.value}" var="item" varStatus="loop">
        ${item} ${!loop.last ? ', ' : ''}
    </c:forEach><br>
</c:forEach>
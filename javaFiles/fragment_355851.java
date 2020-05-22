<div id="nav">
<c:out value="${msg}"></c:out>
<ul>
    <c:forEach var="type" items="${evalTypes}">
    <li><a href="<s:url value="/evalTypes/${type.id}" />"><c:out value="${type.name}" /></a></li>

    </c:forEach>
</ul>
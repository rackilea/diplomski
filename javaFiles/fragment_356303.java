<c:forEach var="i" items="${a}">
    <c:choose><c:when test="${b.contains(i)}">
        <strong><c:out value="${i}"/></strong>
    </c:when><c:otherwise>
        <c:out value="${i}"/>
    </c:otherwise></c:choose>
</c:forEach>
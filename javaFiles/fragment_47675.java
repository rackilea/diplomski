<c:choose>
    <c:when test="${not empty param}">
        <c:redirect url="empLogin.jsp"/>
    </c:when>
    <c:otherwise>
       <c:redirect url="target.jsp"/>
    </c:otherwise>
</c:choose>
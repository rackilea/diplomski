<c:if test="${empty pageContext.request.remoteUser}">
    not logged in
</c:if>
<c:if test="${not empty pageContext.request.remoteUser}">
    logged in
</c:if>
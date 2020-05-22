<c:choose>
    <c:when test="${not empty error.type}">
        ${error.message}
    </c:when>
    <c:when test="${empty error.type}">
        <!-- show your valid message -->
    </c:when>
</c:choose>
<c:choose>
    <c:when test="${empty seats}">
        Seats are empty or null.
    </c:when>
    <c:otherwise>
        Seats are not empty or null
    </c:otherwise>
</c:choose>
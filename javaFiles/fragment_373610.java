<c:choose>
    <c:when test="${requestScope.flag == 1}">
        <!-- flag is 1 -->
    </c:when>
    <c:otherwise>
        <!-- flag isn't 1 -->
    </c:otherwise>
</c:choose>
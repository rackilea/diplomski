<c:forTokens items="${row.date}" delims="/" var="values" varStatus="status">
    <c:if test="${status.index == 0}">
        <c:set var="day" value="${values}"></c:set>
    </c:if>
    <c:if test="${status.index == 1}">
        <c:set var="month" value="${values}"></c:set>
    </c:if>
    <c:if test="${status.index == 2}">
        <c:set var="year" value="${values}"></c:set>
    </c:if>
</c:forTokens>
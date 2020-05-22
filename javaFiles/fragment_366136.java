<c:forEach var="table" items='${requestScope.tables}'>
        <c:out value="${table.name}"></c:out>

        <c:forEach var="column" items='${table.columns}'>
           <c:out value="${column}"></c:out>
        </c:forEach>

        <c:forEach var="row" items='${table.rows}'>
           <c:out value="${row.name}"></c:out>
        </c:forEach>

</c:forEach>
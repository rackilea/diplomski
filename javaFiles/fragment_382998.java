<c:forEach var="f" items="${filemap}">
    <h1><c:out value="${f.key}"/></h1>
    <c:forEach var="g" items="${f.value}">
        <a href="TBD">
            <c:out value="${g.value[0]}"/>
            <c:out value="${g.value[1]}"/>
        </a>
    </c:forEach>
</c:forEach>
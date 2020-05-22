<form:form modelAttribute = "fooList" ...>
    <ul>
    <c:forEach items = "${fooList.foos}" varStatus = "s">
        <li><form:input path = "foos[${s.index}].name" /></li>
    </c:forEach>
    </ul>
</form:form>
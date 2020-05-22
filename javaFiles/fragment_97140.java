<form:select class="select_box" path="country" id="country">
    <c:forEach items="${list}" var="result">
        <form:option value="${result.name}">
            <c:out value="${result.name}"/>
        </form:option>
    </c:forEach>
</form:select>
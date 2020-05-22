<c:forEach items="${fooMap.content}" var="outerMap">
    <c:forEach items="${outerMap.value}" var="innerMap">
        <c:if test="${innerMap.key == 'response'}">
            <p>${innerMap.value}</p>
        </c:if>
    </c:foreach>
</c:forEach>
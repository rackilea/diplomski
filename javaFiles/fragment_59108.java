<table>
    <tr>
        <c:forEach items="${items}" var="item" varStatus="loop">
            <c:if test="${not loop.first and loop.index % 3 == 0}">
                </tr><tr>
            </c:if>
            <td>${item}</td>
        </c:forEach>
    </tr>
</table>
<table>
    <c:forEach items="${items}" var="item">
        <tr>
            <td><c:if test="${item.name != previousName}">${item.name}</c:if></td>
        </tr>
        <c:set var="previousName" value="${item.name}" />
    </c:forEach>
</table>
<table>
    <c:forEach items="${areas}" var="area">
        <tr>
            <td>${area.location}</td>
            <td>${area.timezone}</td>
        </tr>
    </c:forEach>
</table>
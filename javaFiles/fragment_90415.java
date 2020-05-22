<table>
    <c:forEach items="${contacts}" var="contact">
        <tr>
            <td>${contact.username}</td>
            <td>${contact.job}</td>
            <td>${contact.place}</td>
        </tr>
    </c:forEach>
</table>
<form action="yourservlet" method="post">
    <input type="hidden" name="firstrow" value="${firstrow}">
    <input type="hidden" name="rowcount" value="${rowcount}">
    <input type="submit" name="page" value="next">
    <input type="submit" name="page" value="previous">
</form>
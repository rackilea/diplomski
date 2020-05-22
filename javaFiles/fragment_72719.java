<table>
    <c:set var="string2" value="${fn:split(emps,',')}" />
    <c:forEach items="${string2}" var="emps1">
        <tr>
            <td><c:out value="${emps1}"/></td>
        </tr>
    </c:forEach>
</table>
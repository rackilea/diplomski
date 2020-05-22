<table>
    <c:set var="sourceString" value="${fn:split('q,w,e,r,t,y',',')}" />
    <c:forEach items="${sourceString}" var="element">
        <tr>
            <td><c:out value="${element}"/></td>
        </tr>
    </c:forEach>
</table>
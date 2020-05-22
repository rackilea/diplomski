<%
    String[] columnHeaders = {"Banana", "Apple", "Carrot", "Orange", "Lychee", "Permisson"};
    request.setAttribute("columnHeaders", columnHeaders);
%>

<c:forEach var="columnHeader" items="${columnHeaders}">
    <td>
        <c:out value="${columnHeader}" />
    </td>
</c:forEach>
<c:forEach items="${list}" var="listNumber" varStatus="listStatus">
       <c:if test="${listStatus.index < n}">
       <tr>
    <td><c:out value="${listNumber}" /><td>
       </tr>
       </c:if>
    </c:forEach>
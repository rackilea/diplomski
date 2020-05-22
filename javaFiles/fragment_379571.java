<table>
<c:foreach var="item" varStatus="status" items="${requestScope.data}">
 <c:choose>
  <c:when test="${status.index % 4 == 0}">
   <tr>
   <td width="119"><c:out value="${item}" /></td>
  </c:when>
  <c:otherwise>
   <td width="168"><c:out value="${item}" /></td>
  </c:otherwise>   
 </c:choose>
 <c:if test="${status.index % 4 == 3}">
  </tr>
 </c:if>
</c:foreach>
</table>
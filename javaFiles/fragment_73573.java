<c:forEach items="${entries}" var="entry">
  <c:forEach items="${entry.log}" var="logItem">
     <tr><td>${logItem.num}</td></tr>
     ....
  </c:forEach>
</c:forEach>
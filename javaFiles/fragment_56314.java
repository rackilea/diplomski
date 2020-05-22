<c:forEach varStatus="count" var="fruit" items="${fruits}">
...
  <c:when test=${count.index % 6 == 0}> //when loop count is multiple of six
  ... // create your column structure, be it, td, table or div
  </c:when>
</c:forEach>
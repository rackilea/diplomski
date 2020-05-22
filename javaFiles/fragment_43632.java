<c:forEach var="i" begin="0" end="2">
  <c:forEach var="j" begin="0" end="6">
     <c:if test="${(i*7 + j) <=18}">
                       <c:out value="${(i*7 + j)}" />
     </c:if>
  </c:forEach>
  <br />
</c:forEach>
<c:forEach var="type" items="${styles}">
  <br/>
  <c:out value="${type.name}" />
  <c:out value="${type.pcano}" />
  <c:out value="${type.ip}" />
</c:forEach>
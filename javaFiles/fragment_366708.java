<c:forEach items="${configForm.unselectedServers}" var="item">
  <c:set var="name" value="" />
  <c:forEach items="${item.configs}" var="conf">
    <c:set var="name" value="${name}, ${conf.name}" />
  </c:forEach>
</c:forEach>
<c:forEach var="i" begin="1" end="myItem.availableCount">
  <label>
    Item <c:out value="${i}"/>
    <input type='checkbox' value='item<c:out value="${i}"/>' />
  </label>
</c:forEach>
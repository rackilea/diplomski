<table>
  <thead>
    <tr>
      <c:forEach items="${rows[0]}" var="column">
        <td><c:out value="${column.key}" /></td>
      </c:forEach>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${rows}" var="columns">
      <tr>
        <c:forEach items="${columns}" var="column">
          <td><c:out value="${column.value}" /></td>
        </c:forEach>
      </tr>
    </c:forEach>
  </tbody>
</table>
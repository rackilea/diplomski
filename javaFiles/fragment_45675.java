<c:forEach var="p" items="${people.firstnames}" varStatus="status">
  <tr>
      <td>${p}</td>
      <td>${people.lastnames[status.index]}</td>
  </tr>
</c:forEach>
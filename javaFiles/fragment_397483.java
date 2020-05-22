<c:forEach var="results" items="${results}">
   <tr>  
       <td><c:out value="${results.userid}"></c:out></td>
       <td><c:out value="${results.password}"></c:out></td>
       <td><c:out value="${results.role}"></c:out></td>
       <td><c:out value="${results.contact}"></c:out></td>
       <td><c:out value="${results.mentor}"></c:out></td>
       <td><c:out value="${results.group}"></c:out></td>
  </tr>
</c:forEach>
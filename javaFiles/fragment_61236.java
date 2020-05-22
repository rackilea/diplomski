<table>
<c:forEach items="${classList}" var="list">
  <tr><td><h3>Your student from ${list.key}</h3></td></tr>
  <tr><td>
   <table>
   <c:forEach items="${list.value}" var="student">
       <tr>
           <td>${student.name}</td>
           <td>${student.age}</td>
       </tr>
    </c:forEach>
   </table>
  </td></tr>
</c:forEach>
</table>
<table>
 <tr th:each="item : ${items}">
  <td>
   <form th:action="@{/test}" method="post">
    <input type="text" th:value="${item.someField}" name="someField">
    <button type="submit">Submit</button>
   </form>
  </td>
 </tr>
</table>
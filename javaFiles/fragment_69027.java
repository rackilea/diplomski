<table>
  <th:block th:each="value : ${values}">
  <tr>
    <td>Name:</td>
    <td>${value}</td>
  </tr>
  </th:block>
</table>
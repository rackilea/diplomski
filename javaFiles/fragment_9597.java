<tbody>
    <tr th:each="currentClient, stat : *{clientList}">
       <td>
          <input type="checkbox" th:field="*{clientList[__${stat.index}__].selected}" />
          <input type="hidden" th:field="*{clientList[__${stat.index}__].clientID}" />
          <input type="hidden" th:field="*{clientList[__${stat.index}__].ipAddress}" />
          <input type="hidden" th:field="*{clientList[__${stat.index}__].description}" />
       </td>
       <td th:text="${currentClient.getClientID()}"></td>
       <td th:text="${currentClient.getIpAddress()}"></td>
       <td th:text="${currentClient.getDescription()}"></td>               
    </tr>
 </tbody>
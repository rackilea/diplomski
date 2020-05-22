<tr th:each="currentClient, stat : ${wrapper.clientList}">
    <td><input type="checkbox" th:name="|clientList[${stat.index}].clientID|"
            th:value="${currentClient.getClientID()}" th:checked="${currentClient.selected}" /></td>
    <td th:text="${currentClient.getClientID()}"></td>
    <td th:text="${currentClient.getIpAddress()}"></td>
    <td th:text="${currentClient.getDescription()}"></td>
</tr>
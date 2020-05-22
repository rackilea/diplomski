<table class="info table table-hover">
                    <tbody>
                    <tr th:each="customers : ${info}">

                        <td width="20%" th:text="${customers.id}"></td>
                    </tr>
                    </tbody>
                </table>
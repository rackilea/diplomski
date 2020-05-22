<table>
                <span th:each="survey : ${survey}">
                    <h1 th:text="${survey.name}"></h1>
                    <td>
                        <tr th:each="answer: ${answer}">
                            <p th:text="${answer.name}"></p>
                        </tr>
                    </td>
                </span>
              </table>
<c:forEach items="${questionsForSubject}" var="current">
                <tr>
                    <td>
                        <input type="checkbox" name ="choosen_question" value="${current.key}">
                        ${current.value}
                        <br />
                    </td>
                </tr>
</c:forEach>
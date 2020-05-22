<c:forEach var="item" items="${usersList}">
                <tr>
                    <td><c:out value="${item.id}" /></td>
                    <td><c:out value="${item.userName}" /></td>
                    <td><c:out value="${item.password}" /></td>
                    <td><c:out value="${item.email}" /></td>
                    <td><c:forEach var="skill" items="${item.skills}">
                            <c:out value="${skill.typeSkill}"/> 
                        </c:forEach></td>
                </tr>
    </c:forEach>
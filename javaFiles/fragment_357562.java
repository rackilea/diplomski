<c:forEach items="${myForm.list}" var="bean">
            <tr>
                <td><c:out value="${bean[0]}" /></td>
                <td><c:out value="${bean[2]}" /></td>
                <td><c:out value="${bean[1]}" /></td>
            </tr>
        </c:forEach>
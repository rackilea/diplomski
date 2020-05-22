<c:forEach var="person" items="${personView.personList}" varStatus="row">
    <tr>
        <td>{person.fullName}</td>
        <td><form:checkbox path="personList[row.index].supervisor"
                value="true" /></td>
        <td><form:checkbox path="personList[row.index].manager"
                value="true" /></td>
    </tr>
</c:forEach>
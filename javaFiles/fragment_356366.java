<form:form action="submitList" method="post" modelAttribute="myObjectForm">
    <table>
        <tbody>
            <c:forEach items="${myObjectForm.myList}" var="row" varStatus="status">
        <tr>
                <td>
                    <form:checkbox path="myList[${status.index}].checkControl"/>
                    </td>
                    <td>${row.name}</td>
                    <td>${row.code}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>  
    <button type="submit">Submit</button>
</form:form>
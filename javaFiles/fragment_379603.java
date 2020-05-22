<form:form method="post" modelAttribute="editForm">
        <c:forEach items="${editForm.roles}" var="role">
            <c:set var="userRoleId" value="${role.id}" scope="request"/>
        </c:forEach>

        <form:select path="roles" id="role" multiple="false">
            <c:forEach var="tempRole" items="${allRoles}">
                <option value="${tempRole.id}" <c:if test="${tempRole.id == userRoleId}">selected="selected"</c:if> value="${tempRole.id}">${tempRole.role}</option>
            </c:forEach>
        </form:select>
</form:form>
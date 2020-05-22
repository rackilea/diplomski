<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
...
<form:form action="${pageContext.request.contextPath}/logout" 
           method="post" modelAttribute="_csrf">
    <form:button value="submit"> Logout</form:button>
</form:form>
...
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
...

 <spring:hasBindErrors name="person">
    <div class="error">
        <c:forEach var="error" items="${errors.allErrors}">
            <p>Errors ${error.defaultMessage}</p>
        </c:forEach>
    </div>
</spring:hasBindErrors>
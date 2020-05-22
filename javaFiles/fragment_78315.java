<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<s:hasBindErrors name="product">
    <div id="error-noty" style="display:none;">
        <h3>You have errors in your input!</h3>
        <ul>
            <c:forEach items="${errors.fieldErrors}" var="error">
                <li>${error.codes[1]} ${error.defaultMessage}</li>
            </c:forEach>
        </ul>
    </div>
</s:hasBindErrors>
<%@ attribute name="name" required="true" rtexprvalue="true"
              description="Name of corresponding property in bean object" %>
<%@ attribute name="label" required="true" rtexprvalue="true"
              description="Label appears in red color if input is considered as invalid after submission" %>
<%@ attribute name="value" required="true" rtexprvalue="true" type="java.lang.Boolean"
              description="True or False" %>
<spring:bind path="${name}">
    <c:set var="cssGroup" value="control-group ${status.error ? 'error' : '' }"/>
    <div class="${cssGroup}">
        <label class="control-label">${label}</label>

        <div class="controls">
            <form:radiobutton path="${name}" value="${value}"/>
            <span class="help-inline">${status.errorMessage}</span>
        </div>
    </div>
</spring:bind>
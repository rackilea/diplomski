<form:form action="${formUrl}" method="post" modelAttribute="organizationUsersForm">
    <%-- ... other fields ... --%>
    <div id="userSubforms">
        <c:forEach items="${organizationUsersForm.users.entrySet()}" var="subformEntry">
            <div data-subform-key="${subformEntry.key}">
                <spring:nestedPath path="users['${subformEntry.key}']">
                    <%@ include file="user-subform.jspf" %>
                </spring:nestedPath>
            </div>
        </c:forEach>
    </div>
    <button onclick="addSubform(jQuery('#userSubforms'), 'users', 'user', 'userTemplate');">ADD ANOTHER USER</button>
    <%-- other form fields, submit, etc. --%>
</form:form>

<div class="hide" data-subform-template="user">
    <spring:nestedPath path="userTemplate">
        <%@ include file="user-subform.jspf" %>
    </spring:nestedPath>
</div>

<script>
    function addSubform(subformContainer, subformPath, templateName, templatePath) {
        // Find the sequence number for the new subform
        var existingSubforms = subformContainer.find("[data-subform-key]");
        var subformIndex = (existingSubforms.length != 0) ?
                parseInt(existingSubforms.last().attr("data-subform-key"), 10) + 1 : 0;
        // Create new subform based on the template
        var subform = jQuery('<div data-subform-key="' + subformIndex + '" />').
                append(jQuery("[data-subform-template=" + templateName + "]").children().clone(true));
        // Don't forget to update field names, identifiers and label targets
        subform.find("[name]").each(function(node) {
            this.name = subformPath + "["+ subformIndex +"]." + this.name;
        });
        subform.find("[for^=" + templatePath + "]").each(function(node) {
            this.htmlFor = this.htmlFor.replace(templatePath + ".", subformPath + "["+ subformIndex +"].");
        });
        subform.find("[id^=" + templatePath + "]").each(function(node) {
            this.id = this.id.replace(templatePath + ".", subformPath + "["+ subformIndex +"].");
        });
        // Add the new subform to the form
        subformContainer.append(subform);
    }
</script>
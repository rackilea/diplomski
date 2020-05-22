<body onload="document.getElementById('formId:buttonId').click()">
    <h:form id="formId" style="display: none;">
        <h:commandButton id="buttonId" value="submit" action="#{fooBean.logUser()}" />
    </h:form>
    ...
</body>
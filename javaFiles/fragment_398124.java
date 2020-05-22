...
<!-- Login for debugging purposes -->     
<c:forTokens items="${initParam.quickLogin}" delims="," var="loginPassword">
    <c:set var="login" value="${fn:split(loginPassword, ':')[0]}" />
    <c:set var="password" value="${fn:split(loginPassword, ':')[1]}" />

    <form name="debugLogin" action="${form_url}" method="POST" >
        <crsf:hiddenCrsfNonce/>
        <input type="hidden" name='j_username' value="${fn:escapeXml(login)}" />
        <input type="hidden" name='j_password' value="${fn:escapeXml(password)}" />
        <input type="submit" value="${fn:escapeXml(login)} login" />
    </form>
</c:forTokens>
...
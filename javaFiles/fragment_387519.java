<%
    out.println(session.getAttribute("message"));
    session.removeAttribute("message");
%>

<c:out value="${sessionScope.message}" />
<c:remove var="message" scope="session" />
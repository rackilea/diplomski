<%@ (import fn taglib) %>
<%
String var1 = request.getParameter("input");
request.setAttribute("var1",var1);
%>
<c:set var="var1" scope="request" value="${fn:escapeXml(var1)}" />
<%
var1 = (String)request.getAttribute("var1");
%>
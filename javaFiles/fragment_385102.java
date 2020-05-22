<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
...
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
...
<link rel="stylesheet" href="${baseURL}/foo.css" />
<script src="${baseURL}/foo.js"></script>
<a href="${baseURL}/foo.jsp">link</a>
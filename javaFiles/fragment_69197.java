<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:forEach var="objdatatable" items="${requestScope.scriptdataset}">

<c:if test="${not empty objdatatable['vwcmstreevwdata']}">
<c:forEach var="objrecord" items="${objdatatable['vwcmstreevwdata']}">

<c:forEach var="record" items="${objrecord}">

<c:out value="${record['ChildName']}"/>

</c:forEach>

</c:forEach>

</c:if>

</c:forEach>
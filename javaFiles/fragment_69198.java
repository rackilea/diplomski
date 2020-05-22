<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:forEach var="objdatatable" items="${requestScope.scriptdataset}">

<c:if test="${not empty objdatatable['vwcmstreevwdata']}">
<c:forEach var="objrecord" items="${objdatatable['vwcmstreevwdata']}">

<c:out value="${objrecord['ChildName']}"/>

</c:forEach>

 </c:if>

</c:forEach>
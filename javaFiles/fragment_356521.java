<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="total" scope="session" value="${fn:length(list)}"/>
<c:set var="perPage" scope="session"  value="10"/>
<c:set var="pageStart" value="${param.start}"/>
<c:if test="${empty pageStart or pageStart < 0}">
    <c:set var="pageStart" value="0"/>
</c:if>
<c:if test="${total <= pageStart}">
    <c:set var="pageStart" value="${pageStart - perPage}"/>
</c:if>
<a href="?start=${pageStart - perPage}">Previous</a>${pageStart +1} - ${pageStart + perPage} 
<a  href="?start=${pageStart + perPage}">Next</a><br/>
<c:forEach var="item" items="${list}" begin="${pageStart}" end="${pageStart + perPage - 1}" >
        ${item}<br/>
</c:forEach>
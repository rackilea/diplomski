<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
    <c:when test="${1 eq USER_OFFICE}">
       Hello Police
    </c:when>
    <c:when test="${2 eq USER_OFFICE}">
        Hello Doctor
    </c:when>
    <c:otherwise>
        Hello Engineer
    </c:otherwise>
</c:choose>
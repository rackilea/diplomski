// blaview.jsp
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %><%@ taglib uri="http://java.sun.com/jstl/xml" prefix="x" %>
<c:forEach var="searchResult" items="${memberList}">
    <div>
        <h6>${searchResult.nickname}</h6>
        ${searchResult.description}
    </div> 
</c:forEach>
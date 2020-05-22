<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
    <c:when test="${empty sessionScope.User}">
        <a href='register.jsp'>Register</a> 
        <a href='login.jsp'>Login</a>
    </c:when>
    <c:otherwise>
        Hello  <c:out value="sessionScope.User"/>
        <a href='LogoutServlet'>Logout</a>
    </c:otherwise>
</c:choose>
<div class="menu">
    <c:choose>
        <c:when test="${not empty sessionScope.role}">
            <c:if test="${sessionScope.role eq 'admin'}">
                <a href='adminPanel.jsp'>Admin Panel</a></br>
                <a href='userOrders'>Orders</a></br>
            </c:if>
        </c:when>
        <c:otherwise>
            <c:if test="${not empty sessionScope.User}">
                <a href='userOrders'>Orders</a></br></br>
            </c:if>
        </c:otherwise>  
    </c:choose>
</div>
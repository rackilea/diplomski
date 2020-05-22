<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%
    session.setAttribute("cars","vehicles");
    session.setAttribute("toys","playthings");
    session.setAttribute("trees","big plants");
%>
<c:forEach items="${pageContext.session.getAttributeNames()}" var="name" >
   ${name} are ${sessionScope[name]}   <br/> 
</c:forEach>
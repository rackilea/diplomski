<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html> 
   ...

    <c:forEach items="${addresses}" var="addr">
        City:   ${addr.city}   <br/>
        Street: ${addr.street}
    </c:forEach>

   ....
</html>
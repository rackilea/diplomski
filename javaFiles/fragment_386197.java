<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
...
<table>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.size}</td>
            <td>${product.price}</td>
        </tr>
    </c:forEach>
</table>
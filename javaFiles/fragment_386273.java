<table>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.name}</td>
            <td><a href="product?id=${product.id}">detail</a></td>
        </tr>
    </c:forEach>
</table>
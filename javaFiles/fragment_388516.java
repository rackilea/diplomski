<table>
 <c:foreach items="${products}" var="product">
     <tr>
         <td>
            <a href="${pageContext.request.contextPath}/items/${product.category}/${product.name}">${product.name}</a>
         <td>
     </tr>
 </c:foreach>
</table>
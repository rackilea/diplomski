<c:forEach items="${products}" var="product">
  <h2>${product.name}</h2>
  ${product.description} <br/>
  <c:choose>
      <c:when test="${not empty ratings[product.id]}">
          ${ratings[product.id].stars} <br/>
          ${ratings[product.id].comments} <br/>
      </c:when>
      <c:otherwise>
          You have not rated this product
      </c:otherwise>
  </c:choose>
</c:forEach>
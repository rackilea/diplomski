<td><form action="editdetails" method="post">
  <input type="submit" name="action" value="Edit">
  <input type="submit" name="action" value="Delete">
  <input type="hidden" name="productName" value="<c:out value="${current.productName}"/>">
  <input type="hidden" name="quantity" value="<c:out value="${current.quantity}"/>">
  <input type="hidden" name="price" value="<c:out value="${current.price}"/>">
  <input type="hidden" name="vname" value="<c:out value="${current.vname}"/>">
</form></td>
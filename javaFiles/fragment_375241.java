<c:choose>
  <c:when test='${staff.staffRole == "Owner"}'>
    <input type="radio" name="role" id="Owner" value="Owner" checked >
  </c:when>
<c:otherwise>
  <input type="radio" name="role" id="Owner" value="Owner">
</c:otherwise>
</c:choose>
<c:choose>
  <c:when test='${staff.Cashier} == "Owner"}'>
    <input type="radio" name="role" id="Cashier" value="Cashier" checked >
  </c:when>
  <c:otherwise>
    <input type="radio" name="role" id="Cashier" value="Cashier" value="Owner">
  </c:otherwise>
</c:choose>
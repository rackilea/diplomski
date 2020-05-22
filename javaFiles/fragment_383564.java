<c:choose>
  <c:when test="${errorOccured=='true'}">
    <input type="checkbox" name="vehicle" value="Bike">I have a bike
    <br>
    <input type="checkbox" name="vehicle" value="Car" checked>I have a car
    <br>
  </c:when>
  <c:otherwise>
    <input type="checkbox" name="vehicle" value="Bike">I have a bike
    <br>
    <input type="checkbox" name="vehicle" value="Car">I have a car
    <br>
  </c:otherwise>
</c:choose>
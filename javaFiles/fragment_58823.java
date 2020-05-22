<form action="display.jsp" method="GET">
  <select name="sex">
    <c:forEach items="${sexList}" var="sex">
       <option value="${sex}">${sex}</option>
    </c:forEach>
  </select>
  <input type="submit" value="submit"/>
</form>
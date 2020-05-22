Select
<select>
<c:forEach var="item" items="${ListEnvironment}">
   <option><c:out value="${item.string1}"/></option>
</c:forEach>
</select>
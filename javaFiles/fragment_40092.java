<select id="alertFilter">

<c:forEach var="option" items="${user.options}" >
  <option><c:out value="${option.title}"/></option>
</c:forEach>

</select>
<c:forEach var="entry" items="${map}">
   key is ${entry.key}
   <c:forEach var="info" items="${entry.value}">
        info is ${info}
   </c:forEach>
</c:forEach>
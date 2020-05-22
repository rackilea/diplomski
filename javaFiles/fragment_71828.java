<form:select  path="userProfiles"multiple="true"  class="form-control input-sm">
   <c:forEach items="${roles}" var = "role">
      <c:if test="${role.type eq 'USER' or role.type eq 'MODERATOR'}">
         <form:option value="${role.id}" label="${role.type}"/>
      </c:if>
   </c:forEach>
</form:select>
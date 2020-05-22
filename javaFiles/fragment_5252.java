<% java.util.ArrayList<String> userRoleList = (java.util.ArrayList<String>) request.getSession().getAttribute("ROLE_LIST"); 
    pageContext.setAttribute("userRoleList", userRoleList);
%>
<select name="userRole">
    <c:forEach var="role" items="${userRoleList}">
      <option value="${role}">${role}</option>
    </c:forEach>
</select>
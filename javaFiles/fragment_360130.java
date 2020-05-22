<% 
    int z = 0;
    int count = 3 
    do {  
      z++; 
      pageContext.setAttribute("z", z);
      %>
      <c:if test="${not empty array[z]}">
        <td width="50%" height="15px">${array[z]}</td>
      </c:if>
      <%}while (z < count);
%>
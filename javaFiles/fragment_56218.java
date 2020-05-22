<select name="ids">
  <% 
    List<String> idList = request.getAttribute("idList");
    for(String id : idList) {
  %>
      <option><%=id></option>
  <%
    }
  %>
</select>
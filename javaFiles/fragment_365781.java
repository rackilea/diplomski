<select name="item" path="list">
    <%for(String element : list){
          %>
               <option value="<%=element %>"><%=element %></option>
           <%
      }
    %>
  </select>
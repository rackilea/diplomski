<select class="perms" name="perms" multiple="multiple">
   <% for(String permissionStr : permission) {
         String selectedStr="";
         String displayValue=permissionStr.toUpperCase();
         if("all".equals(permissionStr))
         {
            displayValue="ALL Permissions's Allowed";
            selectedStr="selected='selected'";
         }
   %>
      <option value="<%=permissionStr%>" disabled="disabled" <%=selectedStr%> ><%=displayValue%></option>
   <%}%>
</select>
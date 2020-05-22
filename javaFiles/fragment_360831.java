<%
    String defaultText = "Please select a value";
%>
<option value="none"><%= defaultText %></option>
<%
    while (iterator.hasNext())
    {
        Map.Entry mapEntry = (Map.Entry) i.next();
        // getKey Method of HashMap access a key of map
        String keyValue = (String) mapEntry.getKey();
        //getValue method returns corresponding key's value
        String value = (String) mapEntry.getValue();
%>
<option <%= (beanNo!=null && beanNo.equals(keyValue)) ? "selected=\"selected\"" : "" %> value="<%= value %>">
<%= keyValue %>
</option>
<%
    }
%>
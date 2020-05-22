First access the variable in scriptlet.

 <% 
    String param= (String)session.getAttribute("CONNECTION_DBNAME");
 %>

Then use like this.

  <script>
  var X = '<%=param%>';
  </script>
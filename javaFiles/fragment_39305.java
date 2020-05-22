<script>
   var matrix = [];
   <% for (int i=0; i<myArray.length; i++) { %>
     matrix[<%= i %>] = <%= myArray[i] %>; //without the apices
   <% } %>

   ...
  </script>
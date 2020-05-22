<% if (user.getRole() == 1) { >% 
        <p>Some content here</p>
    <% } 
       else { 
    %>
       <p>Content for admin</p>
    <% } %>
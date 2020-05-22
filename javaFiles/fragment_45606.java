<% for(int i = 0; i < comments.size(); i+=4) {             
%>
    <label>ID: <%= comments.get(i) %></label><br/>
    <label>Name: <%= comments.get(i+1) %></label><br/>
    <label>Update_at: <%= comments.get(i+2) %></label><br/>
    <label>Comment: <%= comments.get(i+3) %></label><br/>
<% } %>
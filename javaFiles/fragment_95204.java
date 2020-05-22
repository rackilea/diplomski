<%
ArrayList<String> notifications = new ArrayList<String>();
notifications.add("One");
notifications.add("Two");
notifications.add("Three");

for(int i=0; i<notifications.size(); i++){
%>
    <li>
        <a href="#"><%= notifications.get(i).toString() %></a>
    </li>    
<%}%>
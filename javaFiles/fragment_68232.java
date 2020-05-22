<%
ArrayList<String> processArray=p.getProcessusList();
%>
<table border="1" cellspacing="0">
    <thead>
        <tr>
            <%
            String se = processArray.get(0);
            String[] sa = se.split("\\s\\s+");%>
            <%for (int j=0;j<sa.length;j++){ 
            if(j==1){%>
            <th>PID</th>
            <th>Session Name</th>
            <%} else {%>
            <th><%=sa[j] %></th>
            <%}} %>
        </tr>
    </thead>
    <tbody>
        <%for (int i=1;i<processArray.size();i++){ 
        se = processArray.get(i);
        sa = se.split("\\s\\s+");%>
        <tr>
            <%for (int j=0;j<sa.length;j++){
            if(j==1){
                String ssa[] = sa[j].split(" ");%>
            <td><%=ssa[0] %></td>
            <td><%=ssa[1] %></td>
            <%}else{ %>
            <td><%=sa[j] %></td>
            <%}} %>
        </tr>
        <%} %>
    </tbody>
</table>
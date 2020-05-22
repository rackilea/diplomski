<aui:select name="title">
    <%for(int i = 0; i < listOfOptions.size(); i++){ 
        Object option = listOfOptions.get(i);
        boolean selected = false;
        if(user.getTitle().equals(option.getTitle())){
            selected = true;
        } %>
        <aui:option label=<%=option.getTitle() %> value="<%=option.getValue() %>" selected=<%=selected %> />
    <%} %>
</aui:select>
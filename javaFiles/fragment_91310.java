<select id="food" name="fooditems">

<%
Map<String, String> foods = (Map<String, String>) request.getAttribute("foods");

for(Entry<String, String> food : foods.entrySet()) {
%>

    <option value="<%=food.getKey()%>">
        <%=food.getValue() %>
    </option>

<%
}
%>

</select>
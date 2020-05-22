<%! int i = 0; %>
<c:forEach var="element" items="${string_array}">
    <tr>
        <td><input type="radio"  value="<%= i++ %>" name="item_radio">${element}   </td>    
    </tr>               
</c:forEach>
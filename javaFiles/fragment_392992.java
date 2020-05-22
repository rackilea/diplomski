<c:forEach var="rowItem" items="${rowList}" >
<tr>
    <td>${rowItem.mall}</td>
    <td class="cinema">${rowItem.cinema}</td>
    <td>PHP ${rowItem.price}</td>
    <td>${rowItem.date}</td>
    <td>${rowItem.time}</td>
</tr>
</c:forEach>
<table>
    <c:forEach items="${gear}" var="g" varStatus="vStatus">
        <tr>
            <td>${g.category}</td> 
            <td>${g.desc1}</td>
            <td>${g.quant}</td>
            <td><input type="text" id="${pStatus}" name="${pStatus}"></td>
        </tr>
    </c:forEach>
</table>
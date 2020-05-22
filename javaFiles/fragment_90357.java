<c:forEach items="${items}" var="item">
    <c:out value="${item.name}"/></td>
    <form:hidden path="itemId" value="${item.itemId}"/>
    <button class="reserve-button" type="submit" name="reserve" id="reserve" value="Reserve Item">
           Reserve Item
    </button>        
</c:forEach>
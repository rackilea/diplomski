<select id="food" name="fooditems">
    <c:forEach items="${foods}" var="food">
        <option value="${food.key}">
            ${food.value}
        </option>
    </c:forEach>
</select>
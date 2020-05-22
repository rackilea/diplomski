<select name="bfnsCode" id="bfnsCode" class="sel" style="width: 245px; margin-left: 0;">
    <option selected="selected" value=""></option>
    <c:forEach var="taxtype" items="${birtypelist}">
        <option value="${taxType.bfnsCode}">${taxType.bfnsCode}</option>
    </c:forEach>
</select>
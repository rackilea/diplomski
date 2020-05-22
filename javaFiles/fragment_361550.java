<c:if test="${empty borough}">
    <form:select path="borough">
    <form:option value="Staten Island">Staten Island</form:option>
    <form:option value="Queens">Queens</form:option>
    <form:option value="Brooklyn">Brooklyn</form:option>
    <form:option value="Bronx">Bronx</form:option>
    <form:option value="Manhattan">Manhattan</form:option>
    </form:select>  
</c:if>
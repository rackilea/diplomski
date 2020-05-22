<form method="GET" action="/admin/products.htms">
    <select name="marketId" onchange="this.form.submit();">
        <c:forEach var = "item" items="${marketList}">
            <option value = "${item}">${item}</option>
        </c:forEach>
    </select>
</form>
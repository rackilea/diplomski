<form:form commandName="editMeal" method="post"
    class="form-horizontal form-width">
    <-- other code -->
    <form:select id="categoryList" path="idCategory">
            <c:forEach items="${categories}" var="cat">
                <form:option  value="${category.text}" label="${category.value}"  />
            </c:forEach>
    </form:select>  
</form:form>
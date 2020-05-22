<form method="POST" name="deleteFormAdd" id="deleteFormAdd" enctype="multipart/form-data">
    <input type="hidden" name="_csrf" th:value="${_csrf.token}" />

    //The code can't iterate the String of array given by the GET
    <input type="hidden" class="assetId" th:each="deleteCategory, itemStat : ${DeleteCategoryObject}" th:name="|DeleteCategoryObject[__${itemStat.index}__].assetID|" th:value="${deleteCategory.assetID}"/>

    //This button is for submitting the String of array ID to be deleted
    <input type="button"  class="btn btn-primary btn-block" value="Yes" th:onclick="'javascript:submitForm(\'deleteFormAdd\',\''+@{/delete-asset}+'\')'" />
    <button type="reset" onclick="window.location.href = 'manage-assets.html';" class="btn btn-default btn-block"> Cancel</button>
</form>
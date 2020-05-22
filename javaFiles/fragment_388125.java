<form th:object="${obj}" th:action="@{/list}" action="void(0)" method="post">
    <tr>    
        <td th:field="*{id}" th:text="${obj.id}" /> 
    </tr>
    <tr th:each="l , i : ${obj.someList}">
        <input type="hidden" th:field="*{someList[__${i.index}__].something}" />
    </tr>
    <input type="submit" class="btn btn-success" />
</form>
<form th:action="@{/values/fiatCurrency}" th:object="${fiat}" method="post">
    <select th:field="*{fiatCurrency}" onchange="this.form.submit()">
        <option id="USD" th:value="USD" th:text="USD"></option>
        <option id="EUR" th:value="EUR" th:text="EUR"></option>
        <option id="CNY" th:value="CNY" th:text="CNY"></option>
    </select>
</form>
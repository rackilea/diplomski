<th:block th:each="thread : ${threads}">
    <td th:type="id"><span th:text="${thread.getId()}"></span></td>
    <td><span th:text="${thread.getHeader()}"> Title </span></td>
    <td><span th:text="${thread.getText()}"> Title </span></td>
    <form th:object="${thread}" th:method="post">
        <td><button name="inThread" type="submit">В тред</button></td>
    </form>
</th:block>
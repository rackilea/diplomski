<form action="map.html" th:object="${wrapper}" method="post">
    <table class="table table-striped">
        <tr>
            <th>Property</th>
            <th>Value</th>
        </tr>

        <tr th:each="key : ${wrapper.map.keySet()}">
            <td th:text="${key}" />
            <td>
                <input th:field="*{map[__${key}__]}" />
            </td>
        </tr>
    </table>

    <button type="submit" class="btn btn-default">Submit</button>
</form>
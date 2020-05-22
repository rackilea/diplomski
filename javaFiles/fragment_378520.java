<th:block th:each="char:${sequence}">
        <!--Print the char. Possibility to color encode the bases utilizing switch/case
        <small th:text="${char}"></small> -->
        <div th:switch="${char}">
            <div th:case="'A'">
                <small  style="color: blue" th:text="${char}"></small>
            </div>
            <div th:case="'T'">
                <small  style="color: yellow" th:text="${char}"></small>
            </div>
            <div th:case="'C'">
                <small  style="color: forestgreen" th:text="${char}"></small>
            </div>
            <div th:case="'G'">
                <small  style="color: red" th:text="${char}"></small>
            </div>
        </div>

    </th:block>
<div th:case="'A'" style="display:inline-block;">
            <small  style="color: blue" th:text="${char}"></small>
        </div>
        <div th:case="'T'" style="display:inline-block;">
            <small  style="color: yellow" th:text="${char}"></small>
        </div>
        <div th:case="'C'" style="display:inline-block;">
            <small  style="color: forestgreen" th:text="${char}"></small>
        </div>
        <div th:case="'G'" style="display:inline-block;">
            <small  style="color: red" th:text="${char}"></small>
        </div>
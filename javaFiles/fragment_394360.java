<html>
    <section layout:fragment="menu">
        <ul>
            <li th:each="menuItem : ${menuItemsList}" th:text="${menuItem.name}">
                <section layout:include="@{path/to/folder/menuFragment} :: menu" th:with="menuItemsList=${menuItem.children}"></section>
            </li>
        </ul> 
    </section>
</html>
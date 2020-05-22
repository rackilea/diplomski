<%
    if (request.getAttribute("categoriesList") != null) {%>
        <c:forEach var="categoryName" items="${categoriesList}">
            <input id="${categoryName}" name="categoriesList" type="hidden" value="${categoryName}"/>
            <li><a onclick="getCategoryIndex()" href="#">${categoryName}</a></li>
        </c:forEach>
<% }%>
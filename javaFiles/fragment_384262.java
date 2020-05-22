<c:forEach items="${usersList}" var="userNames" varStatus="stat">
    <c:set var="counter" value="${stat.count + 1}" scope="page"/>
    <li class="msImages">
        <c:choose>
            <c:when test="${counter lt 4}">
                <p> <span> I am creating an image</span> </p>
            </c:when>
            <c:when test="${counter eq 4}">
                <span>See More </span>
            </c:when>
        </c:choose>
    </li>
</c:forEach>
<c:forEach var="school" items="${schoolList}" varStatus="ctr">
    <ul>
        <li>${school}
            <ul>
                <c:forEach var="course" items="${courseList.get(ctr.index)}">
                    <li>${course}</li>
                </c:forEach>
            </ul>
        </li>
    </ul>
</c:forEach>
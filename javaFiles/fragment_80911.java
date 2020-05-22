<c:forEach var="suburb" items="${newList}" >
    <c:forEach var="suburbname" items="${suburb.suburbs.suburbname}">
        <a href="<portlet:actionURL>
                <portlet:param name="action" value="streets"/>
                <portlet:param name="suburbname" value="${suburbname}"/>
            </portlet:actionURL>"> ${suburbname}
        </a> <br /> <br />
    </c:forEach>
</c:forEach>
<c:when test="#{not empty messageBean.getComments(msg)}">
    <c:forEach items="#{messageBean.getComments(msg)}" var="com">
        <div>
        ...
        </div>
    </c:forEach>
</c:when>
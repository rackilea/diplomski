<c:when test="#{com.hasChildren}">
    <c:forEach items="#{com.listComments}" var="subComment">
        <ui:include src="comments.xhtml">
            <ui:param name="comment" value="#{subComment}" />
        </ui:include>
    </c:forEach>
</c:when>
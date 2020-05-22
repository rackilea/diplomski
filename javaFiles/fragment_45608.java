<c:forEach items="${comments}" var="comment">
    <label>ID: ${comment.commentId}</label><br/>
    <label>Name: ${comment.commentedBy}</label><br/>
    <label>Update_at: <fmt:formatDate pattern="yyyy-MM-dd" value="${comment.updateDate}" /></label><br/>
    <label>Comment: ${comment.commentText}</label><br/> 
</c:forEach>
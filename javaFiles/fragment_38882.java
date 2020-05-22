<%@taglib prefic="c" uri="http://java.sun.com/jsp/jstl/core" %>
...
<table>
    <c:forEach items="${mainForumRecords}" var="mainForumRecord">
        <tr>
            <td>${mainForumRecord.mainPostId}</td>
            <td>${mainForumRecord.postHeading}</td>
            <td>${mainForumRecord.postText}</td>
            <td>${mainForumRecord.authorId}</td>
            <td>${mainForumRecord.timeStamp}</td>
        </tr>
    </c:forEach>
</table>
<c:forEach var="contentStatis" items="${resultcount}" >
    <td align="center"><c:out value="${contentStatis.dtm}" /></td>
    <td align="center"><c:out value="${contentStatis.StudentPkg}" /></td>
    <td align="center"><c:out value="${contentStatis.Shared}" /></td>
    <td align="center"><c:out value="${contentStatis.NonShared}" /></td>   
</c:forEach>  <!-- you are missing this bit -->
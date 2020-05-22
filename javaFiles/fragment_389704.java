<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:forEach var="reportGroupList" items="${orgReport.reportGroupList}" varStatus="loop">
    <div onclick="window.open('Report${loop.index}.html', '_blank',
         top=500, left=500, width=400, height=400);">
             ${reportGroupList.ReportGroupName} Report${loop.index}
    </div>
</c:forEach>
<display:table name="bulkDetails" export="true" pagesize="100" id="row" sort="list">
    <display:column title="REQUESTID" sortable="true" media="html">
        <c:url value="../Status" var="url">
            <c:param name="Status_Index" value="${row.REQUESTID}"/>
        </c:url>
        <a href=${url}>${row.REQUESTID}</a>
    </display:column> 

    <display:column title="REQUESTID" sortable="true" media="excel">
        ${row.REQUESTID}
    </display:column>
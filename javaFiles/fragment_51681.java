<s:form theme="simple" method="post">
<display:table name="table" pagesize="25" requestURI="" uid="row">
<display:column title="Select">
    <s:checkbox name="checked[%{#attr.row_rowNum - 1}]" fieldValue="%{#attr.row.cpc}" theme="simple"/>
</display:column>
<display:column property="cpc" title="CPC" sortable="true" headerClass="sortable"/>
<display:column property="companyName" title="Company Name" sortable="true" headerClass="sortable"/>
<display:column property="eventType" title="Event Type" sortable="true" headerClass="sortable"/>
<display:column property="industryType" title="Industry Type" sortable="true" headerClass="sortable"/>
<display:column property="previousEvents" sortable="true" headerClass="sortable"/>
<display:column property="creditNotifications" sortable="true" headerClass="sortable"/>
<display:column property="interimNotifyEnterprise" sortable="true" headerClass="sortable"/>
</display:table>
    <s:submit action="remove" value="Remove" 
    onclick="return confirm('Are you sure you want to delete this item / these items?');"/>
    <s:submit action="displayEdit" value="Edit"/>
    <s:submit value="Add New Row" action="displayAdd"/>
</s:form>
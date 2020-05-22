<c:forEach var="employeeRow" items="${yearReportForm.yearReportDetailLst}" varStatus="row">
 //some other code placed here
<c:forEach var="compName" items="${yearReportForm.components}" varStatus="subrow">
<tr>
  <td>${employeeRow.entryDetails.[compName].componentName}</td>
  <td>${employeeRow.entryDetails.[compName].monthlyValues.April}</td>
  <td>${employeeRow.entryDetails.[compName].monthlyValues.May}</td>
</tr>
</c:forEach>
//some other code placed here
</c:forEach>
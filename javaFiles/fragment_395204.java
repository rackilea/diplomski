<c:forEach var="trackRecord"  varStatus = "number" items="${contractDetails.trackRecordEntries}" >
  <tr class="tafont">
      <td class="varcar"><form:input readonly = "true" path = "installmentNo" id = "installmentNo" /></td>
      <td class="varcar"><form:input readonly = "true" path  = "installmentAmount" id = "installmentAmount" /></td>   
      <td class="varcar"><form:input readonly = "true" path = "dueDate" id = "dueDate" /></td>
      <td class="varcar"><form:input cssClass="recievedDate" path = "recievedDate" id = "recievedDate" /></td>
      <td class="varcar"><form:input id = "recieptAmount" path = "recieptAmount" /></td>
      <td class="varcar"><form:input id = "delayDays" path = "delayDays" /></td>     
 </tr>
 </c:forEach>
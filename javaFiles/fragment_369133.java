<table>
  <s:iterator value="bills" var="bill">
    <tr>
    <td><input type="checkbox" name="selectedBills" value="${bill.id}" id="selectedBills-2"/></td>
    <td style="text-align: right">${bill.amount}</td>
    <td>${bill.date}</td>
    <td>${bill.description}/td>
    </tr>
  </s:iterator>
</table>
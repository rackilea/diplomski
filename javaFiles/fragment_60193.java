<c:if test="${!empty customers}">
....
 <tbody>
 <c:forEach items="${customers}" var="customer">
   <c:url var="editUrl" value="/test/customer/edit?customerId=${customer.customerId}"/>
  <tr>
   <td><c:out value="${customer.customerId}" /></td>
   <td><c:out value="${customer.customerCountry}" /></td> 
   <td><c:out value="${customer.customerName}" /></td>
   <td><a href="${editUrl}">Edit</a></td>
  </tr>
 </c:forEach>
 </tbody>
</table>
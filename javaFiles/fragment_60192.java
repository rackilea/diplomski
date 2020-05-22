<!-- you use it here -->
<c:url var="editUrl" value="/test/customer/edit?customerId=${customer.customerId}"/>
<c:if test="${!empty customers}">
....
 <tbody>
 <!-- and initialize it here -->
 <c:forEach items="${customers}" var="customer">
  <tr>
   <td><c:out value="${customer.customerId}" /></td>
   <td><c:out value="${customer.customerCountry}" /></td> 
   <td><c:out value="${customer.customerName}" /></td>
   <td><a href="${editUrl}">Edit</a></td>
  </tr>
 </c:forEach>
 </tbody>
</table>
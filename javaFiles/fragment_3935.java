<c:forEach begin="0" end="${fn:length(centralityList) - 1}" var="index">
   <tr>
      <td><c:out value="${centralityList[index]}"/></td>
      <td><c:out value="${labelList[index]}"/></td>
   </tr>
</c:forEach>
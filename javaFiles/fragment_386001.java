<c:forEach var="myCode" items="${myCodeList }" varStatus="status">
  <c:set var="myCodeFlag" value="false"
  <tr>
    <th>
      <input type="checkbox" id="myCode${status.index}" name="myCodes" 
        <c:forEach var="checkedCode" items="${checkedList}">
        <c:if test="${checkedCode.codId eq myCode.codId}">
        checked="checked"
        </c:if>
        </c:forEach>
      />
    </th>
    <td>
      <textarea id="myContent${status.index}" name="myContents"
<c:if test="${myCodeFlag eq flase}">disabeld="disabled"</c:if>>
      <c:forEach var="checkedCode" items="${checkedList}">
        <c:if test="${checkedCode.codId eq myCode.codId}">
        ${checkedCode.content}
        </c:if>
      </c:forEach>
</textarea>
    </td>
</th>
</tr>
</c:forEach>
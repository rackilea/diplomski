<c:forEach items="${BooksTable}" begin="0" var="row">  
    <tr>  
      <c:forEach items="${row}" var="cell" varStatus="rowIndex"> 

        <c:if test="${rowIndex.index == 0}" >
           <c:set var="stockValue" value="${cell}" scope="page" />
       </c:if>

        <td>${cell} <BR>  <BR>  </td>  
      </c:forEach>  

      <c:set value="${$row.count}" scope="session" var="itemID" />
       <td><FORM ACTION="CartAccess">
         <INPUT TYPE ="HIDDEN" NAME="item" VALUE="${stockValue}">
        <INPUT TYPE="SUBMIT" NAME="check" VALUE="Add"> </FORM></td>   
    </tr>  
  </c:forEach>
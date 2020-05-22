<TABLE BORDER="1" CELLPADDING="3" CELLSPACING="1" style="text-align: center;">
   <TR>
      <c:forEach var="h" items="${value.getHeaders.get(0)}">
         <TH>${h.title}</TH>
      </c:forEach>
   </TR>
   <c:forEach var="headers" items="${value.getHeaders()}">
      <TR>
         <c:forEach var="header" items="${headers.getHeader}">
            <TD>${header.value}</TD>
         </c:forEach>
      </TR>
   </c:forEach>
</TABLE>
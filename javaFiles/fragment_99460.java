<c:forEach items="${moderators}" var="m">
     <div>${m.firstName}</div>
      <div>
     <c:forEach items="${m.companies}" var="company" varStatus="item">
         ${company.compName}
         <c:if test="${!item.last}">,</c:if>
     </c:forEach>
    </div>
</c:forEach>
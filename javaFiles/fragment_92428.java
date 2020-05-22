function getPageNames() {
  var pageNamesArray = [
  <c:forEach var="p" items="${sessionScope.pageNames}" varStatus="status">
    ${status.first ? '' : ','} "${p}"
  </c:forEach>
  ];

  return pageNamesArray;
}
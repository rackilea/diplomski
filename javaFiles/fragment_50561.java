<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
...
<ul>
  <li>Standard date/time: <fmt:formatDate value="${cal.time}" type="both" /></li>
  <li>Standard date: <fmt:formatDate value="${cal.time}" type="date" /></li>
  <li>Day: <fmt:formatDate value="${cal.time}" pattern="d" /></li>
  <li>Month: <fmt:formatDate value="${cal.time}" pattern="M" /></li>
  <li>Year: <fmt:formatDate value="${cal.time}" pattern="yyyy" /></li>
  <li>dd-MM-yyyy: <fmt:formatDate value="${cal.time}" pattern="dd-MM-yyyy" /></li>
  <li>MM/dd/yyyy: <fmt:formatDate value="${cal.time}" pattern="MM/dd/yyyy" /></li>
</ul>
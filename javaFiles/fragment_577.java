<%
List list = (List)session.getAttribute("list");
Comparator comp = ....
Collections.sort(list, comp);
%>


<c:forEach var="bean" items="<%=list%>">
     ...
</c:forEach>
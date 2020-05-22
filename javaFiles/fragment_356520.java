<%@ page import="java.util.*" %>
<%
   ArrayList<String> list = new ArrayList<String>();
   for(int i = 0; i < 35; i++){
       list.add("item" + i);
   }
   int totalCount = 0;
   int perPage = 10;
   int pageStart = 0; 
   String start = request.getParameter("start");
   if(start != null)pageStart = Integer.parseInt(start);
   if(pageStart < 0)pageStart = 0;
   totalCount = list.size();
   if(pageStart >= totalCount)pageStart = pageStart - perPage;
%>
<a href="<%=request.getRequestURL()%>?start=<%=pageStart - 10 %>">Previous</a>
<%=pageStart + 1 %> - <%=pageStart + 10 %> 
<a href="<%=request.getRequestURL()%>?start=<%=pageStart + 10 %>">Next</a><br/>
<%
   for(int x = pageStart; x < pageStart + perPage && x < list.size(); x++){
       out.print((String)list.get(x) + "<br/>");
   }
%>
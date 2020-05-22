<%=request.getServletPath()%><br>
<%
String name = this.getClass().getName();
String INF = "INF";
int pos = name.indexOf("INF");
if(pos  > -1){
    name = name.substring(pos + INF.length());
    name = name.replaceAll("\\.", "/");
    name = name.replaceAll("\\_", ".");
}
out.println(name);    
%>
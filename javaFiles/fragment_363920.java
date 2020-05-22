<%
  List<Types> styles = (List<Types>) request.getAttribute("styles");
  if(styles!=null){
    for(Types type: styles){
       out.println("<br/>" + type.getName() + " " + type.getPcaNo());
     }
  }
%>
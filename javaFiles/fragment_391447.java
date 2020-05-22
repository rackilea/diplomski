<%
   List<MyBean> lst = (ArrayList<MyBean>)request.getAttribute("display");
   for(MyBean mb : lst){
       out.print(mb.getModel() + "<br/>");
       .....
   }
%>
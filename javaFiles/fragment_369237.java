<form name="submitForm" method="get" action="zakaz" id="form1"  class="dropdown-menu">
 <input type="hidden" name="fio" id="fio" >
 <ul class="dropdown-menu" style="width:500px;">
  <%for(int i=0;i<dataList4.size();i++){%>       
     <li><a href="javascript:void(0)" onclick="submitForm('<%=dataList4.get(i)%>')"><%=dataList4.get(i)%></a></li>
 <%}%>
</ul>
<% String uniqueId=request.getSession().getAttribute("uniqueId") ;
   String url = "/retrievePdf.htm?uniqueId="+uniqueId ;
%>

<object id="COB" data="<%=url%>" type="application/pdf" width="100%" height="100%">

</object>
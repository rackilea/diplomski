<%
   String json = (String) request.getAttribute("userRequestedJsonById");
   if (!StringUtility.isNullOrEmpty(json)) 
   {
       response.setContentType("application/json");
       out.print(json);
   }
   else 
   {
       String xml = (String) request.getAttribute("searcherRespondedXmlById");
       if(!StringUtility.isNullOrEmpty(xml)) 
       {
          response.setContentType("text/xml");
          out.print(xml);
       }
   }
%>
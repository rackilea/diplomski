<%@ page import="com.company.Someclass" %>

<% String ret = "";
if(request.getMethod().equals("GET")){
    response.setContentType("application/json");
    Someclass.getJSONArray().toJSONString();
}
else if(request.getMethod().equals("POST")){
    //todo
}

%>  

<%= ret %>
<%
    List styles = (List)request.getAttribute("styles");
    for(Object style: styles){
        out.println("<br>try: " + style);
    }
%>
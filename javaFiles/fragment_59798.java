<%
    for(int i=0;...){
%>

$('.dhx_combo_input').eq(<%=i%>).attr('style','width: 100%;<%=(highlight.get(i))?"background-color: #FF0000;":""%>');

<%
    }
%>
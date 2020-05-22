String t1 = request.getParameter("t1");  
String t2 = request.getParameter("t2");  
if(((double)t2-(double)t1)>2){  
    t2 = String.valueOf((double)t1 + 2);  
}  

response.sendRedirect(servlet2URL+"?t1="+t1+"&t2="+t2);
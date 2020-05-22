<% 
 if(request.getParameter("pass")!=null && request.getParameter("pass1")!=null){
       String passw1=(String)request.getParameter("pass");
       String passw2=(String)request.getParameter("pass1");
       if(passw1.equals(passw2)){
         //equal
       }
}
   %>
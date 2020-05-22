boolean exceptionOcured =false;    
try{
// your code
}
catch(Exception e){
  exceptionOcured  =true;
}
finally{
// your code to release resources
}

if(exceptionOcured){
 RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
        rd.forward(request, response);
}else{
RequestDispatcher rd = request.getRequestDispatcher("/displayjobs.jsp");
        rd.forward(request, response);
}
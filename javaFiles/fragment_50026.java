String[] name = null;
if (request.getParameterValues("name") != null){
   name = request.getParameterValues("name");
}else if(request.getParameterValues("name[]") != null){
   name = request.getParameterValues("name[]");
}
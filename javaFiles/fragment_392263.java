String query;
if(request.getParameter("count").equals("first")){
     query = "SELECT * FROM abc ORDER BY [someColumn] FETCH FIRST 1 ROWS ONLY"
}else{
     query = "SELECT * FROM abc ORDER BY [someColumn] OFFSET 1 ROWS FETCH NEXT 1 ROWS ONLY" 
}
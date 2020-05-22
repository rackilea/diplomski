String count = request.getParameter("count");
int c = 0;
String query;
if(count != null && count.matches("\\d+")){
    c = Integer.parseInt(count);
    query = "SELECT * FROM abc ORDER BY 'F','S' OFFSET "+String.valueOf(c)+" ROWS FETCH NEXT 1 ROWS ONLY";
}else{
   query = "SELECT * FROM abc ORDER BY 'F','S' FETCH FIRST 1 ROWS ONLY";
}
request.setAttribute("count",++c);
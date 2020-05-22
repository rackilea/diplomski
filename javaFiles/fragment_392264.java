<% 
     String count = request.getParameter("count");
     int c;
     if(count!= null && conut.match("\\d+")){
         c = Integer.parseInt(count);
         c++;
     }else{
         c = 0;
     }
     String query = "SELECT * FROM abc ORDER BY [someColumn] OFFSET "+String.valueOf(c)+" ROWS FETCH NEXT 1 ROWS ONLY"
  %>
   <form action="single.jsp" method="post">   
     <input type="text" name="count"  value="<%=c%>"  style="display:none;">   
     <input type="submit" value="NEXT">   
   </form>
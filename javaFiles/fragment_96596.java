public void doPost(HttpServletRequest request, HttpServletResponse response)
     throws IOException{
   PrintWriter out = response.getWriter(); 
   .......

   String firstname=request.getParameter("firstname");    

   out.println("<p>First Name:"+ firstname +"</p>"); 

    .......
}
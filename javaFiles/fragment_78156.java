public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
{ 
     response.setContentType("text/html");

     PrintWriter writer = response.getWriter();

     writer.println("<h3> Hello World </h3>");



}
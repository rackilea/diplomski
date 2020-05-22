public class ServletClass extends HttpServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws    ServletException, IOException {       

    String firstName = request.getParameter("firstname");
    String lastName = request.getParameter("lastName");
   // and so on.....


   }    
}
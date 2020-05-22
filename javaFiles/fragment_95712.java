public class HelloWorld extends HttpServlet {

  public void doGet(HttpServletRequest request,
                HttpServletResponse response)
        throws ServletException, IOException
  {
     //do some stuff

     //forward to JSP to show result
     String nextJSP = "/WEB_INF/result.jsp";
     RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
     dispatcher.forward(request,response);
  }
}
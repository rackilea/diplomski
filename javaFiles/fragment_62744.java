public class HelloWorld extends HttpServlet {
   public void doGet(HttpServletRequest request,
                     HttpServletResponse response)
                     throws ServletException, IOException {
      // access databases, do calculations etc. here
      String hello = "Hello world!";
      String someBoolean = true;
      request.setAttribute("helloObject", hello);
      request.setAttribute("myBoolean", hello);
      RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp);
      dispatcher.forward(request, response);
   }
}
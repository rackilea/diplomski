public class HelloWorld extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                      throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hi</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Hello World!</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
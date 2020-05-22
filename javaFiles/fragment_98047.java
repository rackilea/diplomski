public class TestServlet extends HttpServlet {
....
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
    request.getSession().setAttribute("test", new Date());
  }
....
}
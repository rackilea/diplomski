@WebServlet(urlPatterns={"/javaScriptServlet"})
public class JavaScriptServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/javascript");
        response.getWriter().write("function test() { alert('peek-a-boo'); }");
    }

}
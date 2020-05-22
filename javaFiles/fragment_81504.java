@WebServlet(name="fooServlet", urlPatterns="/foo")
public class FooServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flip = getInitParameter("flip");
        resp.getWriter().println("<html>" +
            "<head><title>" + getServletName() + "</title></head>" +
            "<body>From " + getServletName() + ": " + flip + "</body>" +
            "</html>"
        );
    }
}
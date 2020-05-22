@WebServlet(urlPatterns = "/WEB-INF/test")
public class Test extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.getWriter().println("helloooooooooooo");
    }

}
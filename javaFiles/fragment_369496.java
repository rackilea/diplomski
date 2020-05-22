public class SomeServlet extends HttpServlet {

    private HttpSession session;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();

        // ...

        Object object = session.getAttribute("foo"); // Not threadsafe!
    }
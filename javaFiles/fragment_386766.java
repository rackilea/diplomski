public class JsonDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        out.println('{');
        // fill with JSON construct
        out.println('}');
        out.flush();
    }

}
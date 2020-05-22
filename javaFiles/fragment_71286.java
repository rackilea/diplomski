public class RestServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String uri = request.getPathInfo();
        Pattern p = Pattern.compile(
            "/([^/]+)/([^/]+)/([^/]+)/([^/]+)/(\d+)(?:,(\d+))*/"
        );
        Matcher m = p.matcher(uri);
        if (m.matches()) {
            String id = m.group(1);
            String vara = m.group(2);
            String varb = m.group(3);
            String deltas = m.group(4);

            // etc
        }
    }
}
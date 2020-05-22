@WebServlet(name = "WorldServlet", urlPatterns = {"/rest"})
public class WorldServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            ... // your code
            out.println(array.toString());
        }
    }
}
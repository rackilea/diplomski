@WebServlet("/robots.txt")
public class RobotsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("Text...\n");
    }

}
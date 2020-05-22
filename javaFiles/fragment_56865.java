@WebServlet("/forward")
public class forward extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/videos/forward.html");
        return;
    }
}
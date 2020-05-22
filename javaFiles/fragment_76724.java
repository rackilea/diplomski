@WebServlet("/imageServlet")
public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create image based on request.getParameter() information.
        // Set proper content type by response.setContentType().
        // Write image to response.getOutputStream().
    }

}
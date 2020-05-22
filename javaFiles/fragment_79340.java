@WebServlet("/images/*")
public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File file = new File(System.getProperty("java.io.tmpdir"), request.getPathInfo());

        response.setHeader("Content-Type", getServletContext().getMimeType(file.getName()));
        response.setHeader("Content-Length", String.valueOf(file.length()));

        InputStream input = new FileInputStream(file);
        OutputStream output = response.getOutputStream();

        // Now write input to output the usual way.
    }

}
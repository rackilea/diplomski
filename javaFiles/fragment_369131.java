@MultipartConfig()
@WebServlet(urlPatterns = { "/upload" })
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Part> parts = req.getParts();
        for (Part part : parts) {
            if (!part.getName().equals("author"))
                continue;
            try (InputStream in = part.getInputStream()){
                String content = CharStreams.toString(new InputStreamReader(in));
                System.out.println(content); // prints the value of author
            }
        }
    }
}
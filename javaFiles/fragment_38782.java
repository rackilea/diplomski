import org.apache.commons.io.IOUtils;

@WebServlet(urlPatterns = {"/test"})
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File f = new File("test.txt");
        resp.setContentLength((int) f.length());
        final FileInputStream input = new FileInputStream(f);
        IOUtils.copy(input, resp.getOutputStream());
        input.close();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final FileOutputStream output = new FileOutputStream("test.txt");
        IOUtils.copy(req.getInputStream(), output);
        output.close();
    }
}
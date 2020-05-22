public class ServletDownloadDemo extends HttpServlet {
    private static final int BYTES_DOWNLOAD = 1024;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
                                                                                       IOException {
        response.setContentType("text/plain");
        response.setHeader("Content-Disposition", "attachment;filename=downloadname.txt");

        String s = "Test\n\nText file contects!!";
        InputStream input = new ByteArrayInputStream(s.getBytes("UTF8"));

        int read = 0;
        byte[] bytes = new byte[BYTES_DOWNLOAD];
        OutputStream os = response.getOutputStream();

        while ((read = input.read(bytes)) != -1) {
            os.write(bytes, 0, read);
        }
        os.flush();
        os.close();
    }
}
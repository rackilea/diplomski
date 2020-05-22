public class DownloadServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/octet-stream; charset=windows-1252");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

        InputStream input = null;
        OutputStream output = null;

        try {
            input = new FileInputStream(new File("file-path-where-generated-pdf-is-stored"));
            output = response.getOutputStream();

            IOUtils.copy(input, output);

            output.flush();
        } catch (IOException e) {
            //log it
        } finally{
            close(input);
            close(output);

            input = null;
            output = null;
        }
    }

    //Right way to close resource
    public static void close(Closeable c) {
        if (c == null) return; 
        try {
            c.close();
        }catch (IOException e) {
            //log it
        }
    }
}
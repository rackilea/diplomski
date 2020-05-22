public class HttpServletResponseCopier extends HttpServletResponseWrapper {

    private ServletOutputStreamCopier copier;
    private ServletOutputStream outputStream;
    private PrintWriter writer;

    /**
     * @param response
     */
    public HttpServletResponseCopier(HttpServletResponse response) {
        super(response);
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException
    {
        if (outputStream != null)
            throw new IOException("output stream already called for this response");
        else {
            outputStream = getResponse().getOutputStream();
            copier = new ServletOutputStreamCopier(this.outputStream);
            return copier;
        }
    }

    @Override
    public PrintWriter getWriter() throws IOException
    {
        if (outputStream != null)
            throw new IOException("print writer already called for this response");
        else {
            outputStream = getResponse().getOutputStream();
            copier = new ServletOutputStreamCopier(outputStream);
            writer = new PrintWriter(new OutputStreamWriter(copier, getResponse().getCharacterEncoding()));
            return writer;
        }
    }

    @Override
    public void flushBuffer() throws IOException
    {
        if (writer != null)
            writer.flush();
        else if (copier != null)
            copier.flush();

    }

    public String getContent()
    {
        String content = "";
        try {
            content = IOUtils.toString(copier.getCopyBuffer(), getResponse().getCharacterEncoding());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

}
public class LogRequest extends HttpServletRequestWrapper {

    public LogRequest(HttpServletRequest request) {
        super(request);
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        //read from tmp file or string.
    }

    @Override
    public BufferedReader getReader() throws IOException {
        //read from tmp file or string
    }

}
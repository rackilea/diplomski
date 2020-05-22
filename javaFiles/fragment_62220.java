public class LengthAwareServletResponseWrapper extends ServletResponseWrapper {

    private final CharArrayWriter out = new CharArrayWriter();

    public LengthAwareServletResponseWrapper(final ServletResponse response) {
        super(response);
    }

    public int getWrittenContentLength() {
        return out.size();
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(out);
    }
}
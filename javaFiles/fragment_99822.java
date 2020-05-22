@WebFilter
public class BufferFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
        throws IOException, ServletException {

        final ByteArrayOutputStream buffer =
            new ByteArrayOutputStream();

        // prepare a new ServletResponseWrapper
        // which returns the buffer as its getOutputStream();

        chain.doFilter(...)

        // now you know how exactly big is your response.

        final byte[] responseBytes = buffer.toByteArray();
        response.setContentLength(responseBytes.length);
        response.getOutputStream().write(responseBytes);
        response.flush();
    }

    @Override
    public void destroy() {
    }
}
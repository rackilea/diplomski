@WebFilter(filterName = "LogContextFilter", urlPatterns = {"/*"})
public class LogContextFilter implements Filter {

    public void init(FilterConfig filterConfig) {

    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        try {
            LogContext.setCorrelationId(UUID.randomUUID().toString());
            chain.doFilter(request, response);
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            //This is critical!
            LogContext.cleanup();
        }

    }

    public void destroy() {

    }

}
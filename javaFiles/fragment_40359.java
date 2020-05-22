public final class SessionCloseFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            chain.doFilter(request, response);
        } finally {
            try {
                // Close and remove session here
            } catch (Exception e) {
                // Log but don't throw the exception
            }
        }
    }

}
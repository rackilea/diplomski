public class MDCFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        try {
            MDC.put("appName", "**APPLICATION_NAME**");
            chain.doFilter(request, response);
        } finally {
            MDC.remove("appName");
        }
    }
}
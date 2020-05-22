public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        MDC.put("username", session.getParameter("username")); // or where ever t is stored
        chain.doFilter(request, response);
    }
}
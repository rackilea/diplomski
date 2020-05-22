public class TrackingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Tracker.start();
        try {
            chain.doFilter(request, response);
        } finally {
            Tracker.stop();
        }
    }

    ...
}
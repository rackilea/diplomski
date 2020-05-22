public class MaxRequestsFilter implements Filter {

    private static Logger cat   = Logger.getLogger(MaxRequestsFilter.class.getName());

    private static final int DEFAULT_MAX_REQUESTS = 7000;
    private Semaphore requestPasses;

    @Override
    public void destroy() {
        cat.info("Destroying MaxRequestsFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        long start = System.currentTimeMillis();
        cat.debug("Filtering with MaxRequestsFilter, current passes are: " + requestPasses.availablePermits());
        boolean gotPass = requestPasses.tryAcquire();
        boolean resumed = ContinuationSupport.getContinuation(request).isResumed();
        try {
            if (gotPass || resumed ) {
                chain.doFilter(request, response);
            } else {
                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
            }
        } finally {
            if (gotPass) {
                requestPasses.release();
            }
        }
        cat.debug("Filter duration: " + (System.currentTimeMillis() - start) + " resumed is: " + resumed);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        cat.info("Creating MaxRequestsFilter");

        int maxRequests = DEFAULT_MAX_REQUESTS;
        requestPasses = new Semaphore(maxRequests, true);
    }

}
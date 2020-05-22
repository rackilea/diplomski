public class UniqueRequestFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {

        String requestID = UUID.randomUUID().toString()
        //save to ThreadLocal...

        try {
            chain.doFilter(req, res);
        }
        finally {
            //remove from ThreadLocal
        }
    }


    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }
}
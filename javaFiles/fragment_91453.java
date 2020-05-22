@WebFilter(filterName="requestTLSFilter")
public class RequestTLSFilter extends Filter {

    private static final ThreadLocal<ServletRequest> THREAD_LOCAL = new ThreadLocal<ServletRequest>();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            THREAD_LOCAL.put(request);
            chain.doFilter(request, response);
        } finally {
            THREAD_LOCAL.remove();
        }
    }

    // Other methods    
}
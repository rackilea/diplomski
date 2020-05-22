@Component
public class SecurityFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
         //you can intercept request and response here
        System.out.println("###### security filter ");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
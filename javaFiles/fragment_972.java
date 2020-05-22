@WebFilter( urlPatterns = "/*" ) // Filter all URLs
public class VersionFilter implements Filter {

    @Override
    public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain ) throws IOException, ServletException {
        // TODO Do your filtering here

    }

    @Override
    public void init( FilterConfig filterConfig ) throws ServletException { ... }

    @Override
    public void destroy() { ... }
}
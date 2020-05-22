@Component
public class CorsFilterConfiguration implements Filter {
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, PATCH, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type, authToken"); //TODO: Fix 'token' to 'OAuth' / 'SAML' header.
        chain.doFilter(req, res);
    }
    public void init(FilterConfig filterConfig) {
    }
    public void destroy() {
    }
}
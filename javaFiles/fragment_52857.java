@WebFilter
public class ConfigFilter implements Filter {
    @Inject
    private SessionBean session;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String requestURI = ((HttpServletRequest) request).getRequestURI();
        if(!session.hasConfig() && !requestURI.startsWith("/configWizard.xhtml")) {
            ((HttpServletResponse) response).sendRedirect("/configWizard.xhtml");
        }
        else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}
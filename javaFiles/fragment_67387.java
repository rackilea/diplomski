public class WSO2SAMLSSOSessionBeanFilter extends SSOAgentFilter {

// ...

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        // TODO figure out the right config for the following line
        servletRequest.setAttribute(SSOAgentConstants.CONFIG_BEAN_NAME, "the right config...");
        super.doFilter(servletRequest, servletResponse, filterChain);
    }
}
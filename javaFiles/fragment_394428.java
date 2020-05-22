public class RequestEncodingFilter implements Filter {

private static final String ENCODING = "encoding";
private String configuredEncoding;

@Override
public void init(FilterConfig filterConfig) throws ServletException {
    configuredEncoding = filterConfig.getInitParameter(ENCODING);
}

@Override
public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    servletRequest.setCharacterEncoding(configuredEncoding);
    filterChain.doFilter(servletRequest, servletResponse);
}

@Override
public void destroy() {
}
@Override    
public void doFilter(final ServletRequest request, final ServletResponse 
response, final FilterChain chain) throws IOException, ServletException 
{
final HttpServletRequest httpRequest = (HttpServletRequest) request;
final String pattern = "(^\/pathToMyApp\/$)|(^\/pathToMyApp\/rest\/.*)|(^\/pathToMyApp\/.*\..*)";
final String baseUri = "/pathToMyApp/";    
if (!httpRequest.getRequestURI().matches(pattern)) {
        logger.warning("--------------------------------------------------------------");
        logger.warning("requestUri: " + httpRequest.getRequestURI());
        logger.warning("uri doesn't match regex, redirecting to root");
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.sendRedirect(baseUri);
        logger.warning("--------------------------------------------------------------");
        return;
    }
}
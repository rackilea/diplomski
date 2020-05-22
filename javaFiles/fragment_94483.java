public class CachedHttpServletRequestFilter implements Filter {

    public static final String HTTP_HEADER_CONTENT_TYPE = "Content-Type";
    public static final String MIME_APPLICATION__X_WWW_FORM_URL_ENCODED = "application/x-www-form-urlencoded";


    private File m_TemporaryFolder;


    public CachedHttpServletRequestFilter() {
        m_TemporaryFolder = new File(/*...your temporary directory goes here...*/);
    }


    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {

        if(servletRequest instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            // Check wether the current request needs to be able to support the body to be read multiple times
            String contentType = StringHelper.getLowercaseTrimmed(request.getHeader(HTTP_HEADER_CONTENT_TYPE));

            if(contentType.equals(MIME_APPLICATION__X_WWW_FORM_URL_ENCODED)) {
                // Override current HttpServletRequest with custom implementation
                CachedHttpServletRequest cachedRequest = new CachedHttpServletRequest(request, m_TemporaryFolder);
                filterChain.doFilter(cachedRequest, servletResponse);
                cachedRequest.cleanup();
                return;
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }


    public void init(FilterConfig filterConfig) throws ServletException {

        try {
            /* ...initialize where your temporary folder is located here... */
            //m_TemporaryFolder = new File(/*...*/);
        }
        catch(Exception e) {
            throw new ServletException(e);
        }
    }


    public void destroy() {
    }
}
private final UDecoder urlDecoder = new UDecoder();
private final Logger logger = LoggerFactory.getLogger(SimpleFilter.class);

@Override
public void init(FilterConfig filterConfig) throws ServletException {
}

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;

    String queryString = httpServletRequest.getQueryString();
    if (queryString != null) {
        ByteChunk byteChunk = new ByteChunk();
        byteChunk.setBytes(queryString.getBytes(), 0, queryString.length());
        try {
            urlDecoder.convert(byteChunk, true);
        } catch (IOException ioException) {
            logger.error("Hazarduos character found in request parameter.");
            httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            return;
        }
    }
    chain.doFilter(request, response);
}

@Override
public void destroy() {
}
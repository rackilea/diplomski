@Override
public void doFilter(
        ServletRequest request, 
        ServletResponse response,
        FilterChain filterChain) 
        throws IOException, ServletException {
    Validate.notNull(filterConfig);
    Validate.isTrue(request instanceof HttpServletRequest);
    HttpServletRequest httpServletRequest =
        (HttpServletRequest) request;
    String requestedSessionId = httpServletRequest.getRequestedSessionId();
    logger.info("requestedSessionId: " + requestedSessionId);
    HttpSession httpSession = httpServletRequest.getSession(false);

    if (requestedSessionId == null) {
        // No need to do anything here if no session exists yet
        logger.debug("No session exists yet");
        filterChain.doFilter(request, response);
    } else {
        if (httpSession == null) {
            Validate.isTrue(response instanceof HttpServletResponse);
            HttpServletResponse httpServletResponse =
                (HttpServletResponse) response;
            handleSessionExpired(
                httpServletRequest,
                httpServletResponse);
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
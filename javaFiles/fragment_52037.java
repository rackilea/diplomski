private void handleSessionExpired(
        HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse) 
        throws IOException, ServletException {
    logger.info("expired session | id: " + 
        httpServletRequest.getRequestedSessionId());
    sendSessionExpiredResponse(httpServletRequest, httpServletResponse);
}
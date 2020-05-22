public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
        throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;

    HttpSession session = request.getSession(false);

    if (session != null) {
        SessionInformation info = sessionRegistry.getSessionInformation(session
                .getId());

        if (info != null) {
            if (info.isExpired()) {
                // Expired - abort processing
                doLogout(request, response);

                String targetUrl = determineExpiredUrl(request, info);

                if (targetUrl != null) {
                    redirectStrategy.sendRedirect(request, response, targetUrl);

                    return;
                }
                else {
                    response.getWriter().print(
                            "This session has been expired (possibly due to multiple concurrent "
                                    + "logins being attempted as the same user).");
                    response.flushBuffer();
                }

                return;
            }
            else {
                // Non-expired - update last request date/time
                sessionRegistry.refreshLastRequest(info.getSessionId());
            }
        }
    }

    chain.doFilter(request, response);
}
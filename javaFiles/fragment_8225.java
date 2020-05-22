public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
        throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;

    if (requiresLogout(request, response)) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (logger.isDebugEnabled()) {
            logger.debug("Logging out user '" + auth
                    + "' and transferring to logout destination");
        }

        this.handler.logout(request, response, auth);

        logoutSuccessHandler.onLogoutSuccess(request, response, auth);

        return;
    }

    chain.doFilter(request, response);
}
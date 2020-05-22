public class OAuthAwareAccessDeniedHandler implements AccessDeniedHandler {
   private static final Log LOG = LogFactory.getLog(OAuthAwareAccessDeniedHandler.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException, ServletException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (oauthSecurityUtils.isUserWithOnlyOAuthRole(auth)) {
            LOG.debug("Prohibited to authorize OAuth user trying to access protected resource.., redirected to /login");
            // Remember the request pathway
            RequestCache requestCache = new HttpSessionRequestCache();
            requestCache.saveRequest(request, response);
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        LOG.debug("Ordinary redirection to /accessDenied URL..");
        response.sendRedirect(request.getContextPath() + "/accessDenied");
    }
}
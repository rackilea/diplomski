public class OAuthAwareUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

private static final Log LOG = LogFactory.getLog(LTIAwareUsernamePasswordAuthenticationFilter.class);


@Override
public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    Authentication previousAuth = SecurityContextHolder.getContext().getAuthentication();
    // Check for OAuth authentication in place
    if (oauthSecurityUtils.isUserWithOnlyOAuthRole(previousAuth)) {
        LOG.debug("OAuth authentication exists, try to authenticate with UsernamePasswordAuthenticationFilter in the usual way");
        SecurityContextHolder.clearContext();
        Authentication authentication = null;
        try {// Attempt to authenticate with standard UsernamePasswordAuthenticationFilter
            authentication = super.attemptAuthentication(request, response);
        } catch (AuthenticationException e) {
            // If fails by throwing an exception, catch it in unsuccessfulAuthentication() method
            LOG.debug("Failed to upgrade authentication with UsernamePasswordAuthenticationFilter");
            SecurityContextHolder.getContext().setAuthentication(previousAuth);
            throw e;
        }
        LOG.debug("Obtained a valid authentication with UsernamePasswordAuthenticationFilter");
        Principal newPrincipal = authentication.getPrincipal();
        // Here extract all needed information about roles and domain-specific info
        Principal rememberedPrincipal = previousAuth.getPrincipal();
       // Then enrich this remembered principal with the new information and return it
        LOG.debug("Created an updated authentication for user");
        return newAuth;
    }
    LOG.debug("No OAuth authentication exists, try to authenticate with UsernamePasswordAuthenticationFilter in the usual way");
    return super.attemptAuthentication(request, response);
}

@Override
protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed)
        throws IOException, ServletException {
    Authentication previousAuth = SecurityContextHolder.getContext().getAuthentication();
    if (oauthSecurityUtils.isUserWithOnlyOAuthRole(previousAuth)) {
        LOG.debug("unsuccessfulAuthentication upgrade for OAuth user, previous authentication :: "+ previousAuth);
        super.unsuccessfulAuthentication(request, response, failed);
        LOG.debug("fallback to previous authentication");
        SecurityContextHolder.getContext().setAuthentication(previousAuth);
    } else {
        LOG.debug("unsuccessfulAuthentication for a non-OAuth user with UsernamePasswordAuthenticationFilter");
        super.unsuccessfulAuthentication(request, response, failed);
    }
}
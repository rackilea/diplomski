public class RefreshingUserDetailsSecurityContextRepository implements SecurityContextRepository {

    private final SecurityContextRepository delegate;
    private final UserDetailsService userDetailsService;

    public RefreshingUserDetailsSecurityContextRepository(final SecurityContextRepository delegate, final UserDetailsService userDetailsService) {
        Assert.notNull(delegate);
        Assert.notNull(userDetailsService);
        this.delegate = delegate;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public SecurityContext loadContext(final HttpRequestResponseHolder requestResponseHolder) {
        SecurityContext securityContext = delegate.loadContext(requestResponseHolder);

        if(securityContext.getAuthentication() == null) {
            return securityContext;
        }

        Authentication principal = securityContext.getAuthentication();
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());

        //this code has to be modified when using remember me service, jaas or a custom authentication token
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword());

        securityContext.setAuthentication(token);
        saveContext(securityContext, requestResponseHolder.getRequest(), requestResponseHolder.getResponse());
        return securityContext;
    }

    @Override
    public void saveContext(final SecurityContext context, final HttpServletRequest request, final HttpServletResponse response) {
        delegate.saveContext(context, request, response);
    }

    @Override
    public boolean containsContext(final HttpServletRequest request) {
        return delegate.containsContext(request);
    }
}
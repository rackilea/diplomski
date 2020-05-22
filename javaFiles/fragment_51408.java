@Singleton
public MyUserFilter extends FilterOfTheMonth {

    private final Provider<Authenticator> authProvider;

    @Inject
    MyUserFilter(Provider<Authenticator> auth) {
        this.authProvider = auth;
    }

    public void doFilter(ServletRequest request, ServletResponse response, 
            FilterChain chain) throws java.io.IOException, ServletException {
        try {
            // Authenticate and SET the current user utilizing the request and/or                       
            // session objects
            authProvider.get().authenticateUser(HttpRequest currentRequest);

            // Continue on here along the servlet chain
            ... other processing
        } finally {
            authProvider.get().getRidOfCurrentUser();
        }
    }
}
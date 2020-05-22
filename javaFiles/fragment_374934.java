@Component
public class CustomX509AuthenticationFilter extends X509AuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    @Autowired
    public CustomX509AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(isAdminUser(request)){
            super.doFilter(request, response, chain);
        }
        else {
            Authentication unauthenticatedToken = getUserCredentialsFromRequest(request);
            Authentication authenticatedToken = authenticationManager.authenticate(unauthenticatedToken);
            if(authenticatedToken.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(authenticatedToken);
                chain.doFilter(request, response);
            }
            else {
                throw new BadCredentialsException("Invalid Credentials");
            }
        }
    }

    private Authentication getUserCredentialsFromRequest(ServletRequest request) {
        // logic to retrieve user credentials from request and create initial Authentication
        return ...
    }

    private boolean isAdminUser(ServletRequest request) {
        // logic to determine whether or not user is admin
        return ...
    }
}
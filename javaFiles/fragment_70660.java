public class JWTTokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    @Autowired
    private JWTUtil jwtUtil;

    private static final Logger logger = Logger.getLogger(JWTTokenAuthenticationFilter.class);

    public JWTTokenAuthenticationFilter(){
        this("/api/");
    }

    public JWTTokenAuthenticationFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
        setAuthenticationManager(new NoOpAuthenticationManager());
        setAuthenticationSuccessHandler(new JWTSuccessAuthenticationHandler());
    }

    public final String HEADER_SECURITY_TOKEN = "Authorization";

    @Override
    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
        return true;
    }


    /**
     * Attempt to authenticate request - basically just pass over to another method to authenticate request headers
     */
    @Override public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String header = request.getHeader(HEADER_SECURITY_TOKEN);
        if (header == null || !header.startsWith("Bearer ")) {
            throw new JwtTokenMissingException("No JWT token found in request headers");
        }

        /* Try to parse the token */
        AppUser userDetails = jwtUtil.parseToken(header.substring(7));
        Collection<SimpleGrantedAuthority> auth = new ArrayList<>();
        auth.add(new SimpleGrantedAuthority(userDetails.getRole().name()));

        JWTAuthenticationToken token = new JWTAuthenticationToken(userDetails.getEmail(), userDetails, auth);
        token.setAuthenticated(true);

        return token;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);

        // As this authentication is in HTTP header, after success we need to continue the request normally
        // and return the response as if the resource was not secured at all
        chain.doFilter(request, response);
    }

}
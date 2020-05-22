public class AuthFilter extends AbstractAuthenticationProcessingFilter {

  private static final String AUTH_HEADER = "Authorization";

  public AuthFilter(RequestMatcher reqMatcher) {
    super(reqMatcher);

    this.setAuthenticationSuccessHandler((req1, res1, auth) -> { });
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
      throws AuthenticationException, IOException, ServletException {

    String token = req.getHeader(AUTH_HEADER);

    if (token == null || token.isEmpty()) {
      throw new BadCredentialsException("Token is not present!");
    }

    AuthToken authToken = new AuthToken(token);
    authToken.setDetails(authenticationDetailsSource.buildDetails(req));

    return this.getAuthenticationManager().authenticate(authToken);
  }

  @Override
  protected void successfulAuthentication(
    HttpServletRequest req, 
    HttpServletResponse res, 
    FilterChain chain, 
    Authentication auth
  ) throws IOException, ServletException {

    super.successfulAuthentication(req, res, chain, auth);

    chain.doFilter(req, res);
  }
}
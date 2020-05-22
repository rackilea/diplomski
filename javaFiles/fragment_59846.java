public CustomAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

  private final ObjectMapper mapper;

  public CustomAuthenticationFilter(ObjectMapper mapper) {
    super(new AntPathRequestMatcher("/auth/login", "POST"));
    this.mapper=mapper;
  }

  public Authentication attemptAuthentication(HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException, IOException,
            ServletException {

      MyPrincipal principal = mapper.readValue(request.getInputStream(), MyPrincipal.class);
      MyAuthentication authentication = new MyAuthentication(principal);
      setDetails(request, authentication); //assuming you are extending AbstractAuthenticationToken
      return getAuthenticationManager().authenticate(authentication);

   }

    protected void setDetails(HttpServletRequest request,
            MyAuthentication authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }

}
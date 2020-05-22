public class MyFilter extends OncePerRequestFilter {

  private static final String[] excludedEndpoints = new String[] {"*/foo/**, */bar/**"};

  @Override
  protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
    return Arrays.stream(excludedEndpoints)
        .anyMatch(e -> new AntPathMatcher().match(e, request.getServletPath()));
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    // Filtering logic goes here. call below line on successful authentication.
    filterChain.doFilter(request, response);
  }
}
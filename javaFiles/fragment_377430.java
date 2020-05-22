private AuthenticationEntryPoint authenticationEntryPoint() {
  return new AuthenticationEntryPoint() {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
      httpServletResponse.getWriter().append("Not authenticated");
      httpServletResponse.setStatus(401);
    }
  };
}
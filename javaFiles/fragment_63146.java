void doFilter(ServletRequest request, ServletResponse response,
              FilterChain chain) throws IOException, ServletException {
  setupMDC();
  chain.doFilter(request, response);
  tearDownMDC();
}
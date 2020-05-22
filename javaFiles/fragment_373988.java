public class FilteringServletFilter implements Filter {

  private List<String> excludedPaths = new ArrayList<String>();

  public void init(FilterConfig config) throws ServletException {
    // You can declare a comma separated list to hold your excluded paths
    this.excludedPaths = Arrays.asList(config.getInitParameter("excludedPaths").split(","));
  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    String path = ((HttpServletRequest) request).getRequestURI();
    // If the url is one of excluded paths, then just continue with next filter
    if (this.excludedPaths.contains(path)) {
      chain.doFilter(request, response); 
      return;
    }
    // Otherwilse, forward the request to the needed filter
    else {
      request.getRequestDispatcher("/tokenizedpaths" + path).forward(request, response);
    }
  }

}
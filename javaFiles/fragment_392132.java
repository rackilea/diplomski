public class PersistenceManagerFilter implements Filter { 
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  public void destroy() {
  }

  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain)  throws IOException, ServletException {
    PersistenceManager pm = PMF.get().getPersistenceManager();
    try {
      request.setAttribute("pm", pm);
      chain.doFilter(request, response);
    } finally {
      pm.close();
    }
  }
}
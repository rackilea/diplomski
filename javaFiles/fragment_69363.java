public class RfOrchestraParamControlFilter implements Filter {
   ...
   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      response = new RfOrchestraParamControlResponseWrapper((HttpServletResponse)response);
      chain.doFilter(request, response);
   }
   ...
}
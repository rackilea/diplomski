@WebFilter(filterName = "myFilter", urlPatterns = {"*.xhtml"})
public class MyFilter implements Filter {

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
      String path = ((HttpServletRequest) request).getServletPath();

      if (excludeFromFilter(path)) chain.doFilter(request, response);
      else // do something
   }

   private boolean excludeFromFilter(String path) {
      if (path.startsWith("/javax.faces.resource")) return true; // add more page to exclude here
      else return false;
   }
}
public class CharsetFilter
  implements Filter {

  String encoding = "UTF-8";

  public void destroy() {
    /* Do nothing */
  }

  public void doFilter(ServletRequest request,
         ServletResponse response,
         FilterChain chain) throws IOException, ServletException {

    response.setCharacterEncoding(encoding);
    chain.doFilter(request, response);        
  }

  public void init(FilterConfig config) throws ServletException {       
  }
}
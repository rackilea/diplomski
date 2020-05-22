@WebFilter("/rest/*")
public class RestyFilter implements Filter {
  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
                       FilterChain chain) throws IOException, ServletException {
    request.getRequestDispatcher("/resty.faces").forward(request, response);
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void destroy() {} 
}
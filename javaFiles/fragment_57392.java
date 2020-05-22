@WebFilter(filterName = "Filter", urlPatterns = { "/filter/*" })
public class WebFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
         .......
    }

   .......
  }
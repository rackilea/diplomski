@WebFilter(urlPatterns="/")
public class RequestContextFilter implements Filter {
     public void doFilter(..) {
         RequestContext.initialize();
         try {
             chain.doFilter(request, response);
         } finally {
             RequestContext.cleanup();
         }
     }
}
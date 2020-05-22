@Startup
@Scope(ScopeType.APPLICATION)
@Name("ipFilter")
@BypassInterceptors
@Filter(around ="org.jboss.seam.web.ajax4jsfFilter")
public class IpFilter extends AbstractFilter {

  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
          throws IOException, ServletException {

      if (!(req instanceof HttpServletRequest)) {
          chain.doFilter(req, res);
          return;
      }

      HttpServletRequest request = (HttpServletRequest) req;

      Set<String> ips = (Set<String>)Component.getInstance("blockedIps");
      if(ips.contains(request.getRemoteAddr())) {
        throw new ServletException("Permission denied");
      }

      chain.doFilter(req, res);

    }
}
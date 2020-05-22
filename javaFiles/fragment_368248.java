import javax.servlet.*;  

public class RequestFilter implements Filter{  

  public void init(FilterConfig config) throws ServletException {}  

  public void doFilter(ServletRequest req, ServletResponse res,  
      FilterChain chain) throws IOException, ServletException {  
        HttpServletRequest request = (HttpServletRequest)req;
        String callerIp = request.getRemoteAddr();
        if(callerIp.equalsIgnoreCase("MY-SERVER-IP-ADDRESS")) {
          chain.doFilter(req, res);
        }
        else {
          ((HttpServletResponse)res).sendError(HttpServletResponse.SC_FORBIDDEN, "Access denied !");
          return;
        }  
    }

    public void destroy() {}  
}
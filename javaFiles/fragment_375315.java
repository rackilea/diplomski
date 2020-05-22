@WebFilter("/protected/*")
public class OneTabFilter implements Filter {

  private static final String MARKER_NAME = "marker";
  private static final String MARKER_VALUE = "4711*0815";

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    final HttpServletRequest req = (HttpServletRequest) request; 
    final HttpServletResponse rsp = (HttpServletResponse) response;
    HttpSession session = req.getSession(false);
    if(session == null) {
      session = req.getSession(true);
      // Put the marker value into session so it is usable in JSP files.
      session.setAttribute(MARKER_NAME, MARKER_VALUE);
      // pass the request along the filter chain
      chain.doFilter(request, response);
    } else {
      if(MARKER_VALUE.equals(req.getParameter(MARKER_NAME))) {
        // pass the request along the filter chain
        chain.doFilter(request, response);
      } else {
        // Redirect to the error page.
        // The error page itself is not affected by this filter.
        rsp.sendRedirect(req.getServletContext().getContextPath() + "/error.jsp");
      }
    }
  }

  // ...
}
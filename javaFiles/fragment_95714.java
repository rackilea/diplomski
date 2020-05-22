public class MyFilter implements Filter {

  public void doFilter(ServletRequest req, ServletResponse res,
        FilterChain chain) throws IOException, ServletException {

    if (isLoggedIn) {
      //if user is logged in, complete request
      chain.doFilter(req, res);
    } else {
      //not logged in, go to login page
      res.sendRedirect("/login");
  }
}
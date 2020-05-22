public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain)
{
    HttpServletResponse response=(HttpServletResponse) resp;

    boolean authenticated=false;
    // perform authentication

    if (authenticated)
    {
         chain.doFilter(req, response);
    }
    else
    {
         // don't continue the chain
         response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
         response.setHeader("WWW-Authenticate", "BASIC realm=\"Your realm\"");

         response.setContentType("what you need");
         PrintWriter writer=response.getWriter();

         // don't set content length , don't close
    }
}
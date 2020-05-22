public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
throws IOException, ServletException {
    ...
    [other processing/validations]
    ...
    if(request.getServerName().equals("domain1.com"))
      request.getRequestDispatcher("/servlet1").forward(request, response)
    else
      request.getRequestDispatcher("/servlet2").forward(request, response)

}
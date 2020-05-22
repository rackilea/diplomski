@Override public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
                                throws IOException, ServletException
  {
    HttpServletRequest request = (HttpServletRequest) req;
    String requestAddress = request.getRequestURI();
    String country_code = req.getLocale().getCountry();

    if (requestAddress.contains("/help/")) 
    {
        ServletContext forwardContext = config.getServletContext().getContext("/help_" + country_code);

        forwardContext.getRequestDispatcher(requestAddress.replace("/help", "")).forward(req, res);
    } 
    else 
    {
        chain.doFilter(req, res);
    }
  }
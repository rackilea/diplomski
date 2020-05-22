public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain p_filterChain) throws IOException, ServletException {


    long startTime = System.currentTimeMillis();
    String url = "unknown"; 
    if (request instanceof HttpServletRequest) {
         url = ((HttpServletRequest)request).getRequestURL().toString();
         String queryString = ((HttpServletRequest)request).getQueryString();
         if(queryString != null)
             url += "?" + queryString;
    }


    p_filterChain.doFilter(request, response);

    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;

    LogManager logm = new LogManager();
    logm.newLog(url,elapsedTime);
    System.out.println("Request: " + url + "  " + elapsedTime + "ms");        
}
@Override
protected void doFilterInternal(HttpServletRequest request,
                                HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {

    HttpServletResponse myResponse = (HttpServletResponse) response;
    MyResponseRequestWrapper responseWrapper = new MyResponseRequestWrapper(myResponse);
    responseWrapper.addHeader("Access-Control-Allow-Origin", "*");
    filterChain.doFilter(request, myResponse);
}
@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    Enumeration<String> headerNames = httpRequest.getHeaderNames();

    if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                    System.out.println("Header: " + httpRequest.getHeader(headerNames.nextElement()));
            }
    }

    //doFilter
    chain.doFilter(httpRequest, response);
}
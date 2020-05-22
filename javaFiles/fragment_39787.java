public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
        throws IOException, ServletException {

    HttpServletRequest request = (HttpServletRequest) servletRequest;
    System.out.println("CORSFilter HTTP Request: " + request.getMethod());

    // Authorize (allow) all domains to consume the content
    ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", "*");
    ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, POST");

    HttpServletResponse resp = (HttpServletResponse) servletResponse;

    // For HTTP OPTIONS verb/method reply with ACCEPTED status code -- per CORS handshake
    if (request.getMethod().equals("OPTIONS")) {
        resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        return;
    }

    // pass the request along the filter chain
    chain.doFilter(request, servletResponse);
}
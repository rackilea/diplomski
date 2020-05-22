public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    // pass the request along the filter chain
    chain.doFilter(request, response); <-------------------- PROBLEM

    if (request instanceof HttpServletRequest) {
        localRequest.set((HttpServletRequest) request);
    }

    try {
        chain.doFilter(request, response);
    } finally {
        localRequest.remove();
    }
}
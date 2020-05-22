public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {       
    try {
        chain.doFilter(request, response);
    } finally {
        DBUtil.close();         
    }
}
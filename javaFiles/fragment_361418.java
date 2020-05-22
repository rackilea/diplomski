public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
    if (((HttpServletRequest) request).getSession().getAttribute("user") == null) {
        // User is not logged in. Redirect to login page.
        ((HttpServletResponse) response).sendRedirect("login");
    } else {
        // User is logged in. Just continue with request.
        chain.doFilter(request, response);
    }
}
public void doFilter(ServletRequest req, ServletResponse res,
        FilterChain chain) throws ServletException, IOException {

      HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();

        if (session == null || session.getAttribute("User") == null) {
              response.sendRedirect(request.getContextPath() + "/index.xhtml"); // No logged-in user found, so redirect to login page.
        } else {
            chain.doFilter(req, res); // Logged-in user found, so just continue request.
        }
}
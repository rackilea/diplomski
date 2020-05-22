public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("name") == null) {
            response.sendRedirect(request.getContextPath() + "/link"); 
        } else {
            chain.doFilter(req, res); 
        }
    }
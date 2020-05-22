public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
    throws IOException, ServletException {

    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    HttpSession session = request.getSession();

    String email = req.getParameter("email");
    session.setAttribute("email", email);

    chain.doFilter(req, res); // continue to 'ShowOnline'

}
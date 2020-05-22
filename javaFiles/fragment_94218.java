@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {    
    HttpServletRequest req = (HttpServletRequest) request;
    Autenticar auten = (Autenticar) req.getSession().getAttribute("aut");

    if (auten == null || !auten.isLogueado()) {
        // User is not logged in, so redirect to index.
        HttpServletResponse res = (HttpServletResponse) response;
        res.sendRedirect(req.getContextPath() + "/faces/index.xhtml");
    }
    //Just continue request.
    chain.doFilter(request, response);
}
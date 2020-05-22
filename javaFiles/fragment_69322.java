class LoginPageFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (SecurityContextHolder.getContext().getAuthentication() != null
              && SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
              && ((HttpServletRequest)request).getRequestURI().equals("/login")) {
            System.out.println("user is authenticated but trying to access login page, redirecting to /");
            ((HttpServletResponse)response).sendRedirect("/");
        }
        chain.doFilter(request, response);
    }
}
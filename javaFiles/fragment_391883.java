@Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;

    if ("GET".equals(request.getMethod()) && request.getParameter("JSESSIONID") != null) {
        response.sendRedirect(request.getRequestURL().append(";JSESSIONID=")
            .append(request.getParameter("JSESSIONID")).toString());
    } else {
        chain.doFilter(request, response);
    }
}
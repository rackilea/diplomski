@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

    // dynamically add mappings
    ServletContext context = request.getServletContext();
    ServletRegistration registration = context.getServletRegistration("hello");
    registration.addMapping("/<dynamic path>/hello");

    request.getRequestDispatcher("/hello").include(request, response);
    request.getRequestDispatcher("/hello.jsp").include(request, response);
}
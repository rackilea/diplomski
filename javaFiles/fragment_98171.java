public class RedirectionFilter implements Filter {

    /**
     * Default constructor.
     */
    public RedirectionFilter () {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) res;

            String servletPath = request.getServletPath();

            if (servletPath.endsWith(".html")) {
                response.sendRedirect("http://secondwebsite.com" + servletPath);
            }
            else {
                chain.doFilter(request, response);
            }
}
@Override
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub

    }
}
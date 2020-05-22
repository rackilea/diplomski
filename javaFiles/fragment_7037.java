public class GetStatusResponseFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, 
                         ServletResponse response, 
                         FilterChain filterChain) 
                            throws IOException, ServletException {
        GetStatusWrapper wrapper;
        wrapper = new GetStatusWrapper((HttpServletResponse) response);
        filterChain.doFilter(request, wrapper);
        System.out.println("status = " + wrapper.getStatus());
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
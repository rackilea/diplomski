public static class PhoneNumberFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws
                                                                                                    ServletException,
                                                                                                    IOException {
        filterChain.doFilter(new PhoneRequestWrapper((HttpServletRequest) request), response);
    }

    @Override
    public void destroy() {

    }
}
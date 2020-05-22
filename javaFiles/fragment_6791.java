@Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletRequestWrapper wrapped = new HttpServletRequestWrapper(request) {
            @Override
            public StringBuffer getRequestURL() {
                final StringBuffer originalUrl = ((HttpServletRequest) getRequest()).getRequestURL();
                final String updatedUrl = originalUrl.toString().replace("http://", "https://");
                return new StringBuffer(updatedUrl);
            }
        };
        filterChain.doFilter(wrapped, servletResponse);
    }
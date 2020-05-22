filterChain.doFilter(servletRequest,
        new HttpServletResponseWrapper((HttpServletResponse) servletResponse) {
            @Override
            public void setHeader(String name, String value) {
                if (!HTTPCacheHeader.ETAG.getName().equalsIgnoreCase(name)) {
                    super.setHeader(name, value);
                }
            }
        });
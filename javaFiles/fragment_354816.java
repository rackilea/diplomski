http.headers()
        .addHeaderWriter(new DelegatingRequestMatcherHeaderWriter(
                new AntPathRequestMatcher("/javax.faces.resource/**"),
                new HeaderWriter() {

                    @Override
                    public void writeHeaders(HttpServletRequest request,
                            HttpServletResponse response) {
                        response.addHeader("Cache-Control", "private, max-age=86400");
                    }
                }))
        .defaultsDisabled();
@Override
protected void configure() {
    bindScope(RequestScoped.class, ServletScopes.REQUEST);

    bind(ServletRequest.class).toProvider(unusableProvider(ServletRequest.class)).in(RequestScoped.class);
    bind(HttpServletRequest.class).toProvider(unusableProvider(HttpServletRequest.class)).in(RequestScoped.class);
    bind(ServletResponse.class).toProvider(unusableProvider(ServletResponse.class)).in(RequestScoped.class);
    bind(HttpServletResponse.class).toProvider(unusableProvider(HttpServletResponse.class)).in(RequestScoped.class);
}

private static <T> Provider<T> unusableProvider(final Class<T> type) {
    return new Provider<T>() {
        @Override
        public T get() {
            throw new IllegalStateException("Unexpected call to provider of " + type.getSimpleName());
        }
    };
}
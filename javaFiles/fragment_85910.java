public static <R extends ServletRequest> R unwrap(ServletRequest request, Class<R> type) {
    ServletRequest current = request;

    while (!type.isInstance(current) && current instanceof ServletRequestWrapper) {
        current = ((ServletRequestWrapper) current).getRequest();
    }

    return type.isInstance(current) ? type.cast(current) : null;
}
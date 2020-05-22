String path = request.getRequestURI().substring(request.getContextPath().length());

if (path.startsWith("/acc" + ResourceHandler.RESOURCE_IDENTIFIER)) {
    chain.doFilter(request, response);
} else {
    // ...
}
private boolean allModulesAreLoaded;

@Override
public void init(FilterConfig config) {
    try {
        // Load modules.
        allModulesAreLoaded = true;
    } catch (Exception e) {
        // Handle.
    }
}

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
    if (allModulesAreLoaded) {
        chain.doFilter(request, response);
    } else {
        throw new ServletException("Not all modules are loaded.");
    }
}
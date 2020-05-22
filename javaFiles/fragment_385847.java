public class PageByResourceAccessDeniedHandler extends AccessDeniedHandlerImpl {

    //~ Instance fields ===================================

    /**A Map of Path by Error Page*/
    private Map<String, String> errorPagesByPaths;
    /**The default error page if any of {@link #errorPagesByRole} matches */
    private String defaultErrorPage;

    //~ Main Methods ======================================

    @Override
    public void handle(HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException,
            ServletException {
        String errorPage = determineErrorPage(request);
        setErrorPage(errorPage);
        super.handle(request, response, accessDeniedException);
    }

    /**
     * Searches into the property {@link #errorPagesByRole} for a matching error page
     * for the current denied request path.
     * @param request current request
     * @return a matching error page found in {@link #errorPagesByRole} or {@link #defaultErrorPage}
     * if none was found.
     */
    private String determineErrorPage(HttpServletRequest request) {
        AntPathMatcher apm = new AntPathMatcher();

        for (String key : errorPagesByPaths.keySet()) {
            if(apm.match(key, request.getServletPath())) {
                return errorPagesByPaths.get(key);
            }
        }
        return defaultErrorPage;
    }

    //~ Getters/Setters/Utilities =========================

    public void setErrorPagesByPaths(Map<String, String> errorPagesByPaths) {
        for (String key : errorPagesByPaths.keySet()) {
            validateErrorPage(errorPagesByPaths.get(key));
        }
        this.errorPagesByPaths = errorPagesByPaths;
    }

    public void setDefaultErrorPage(String errorPage) {
        validateErrorPage(errorPage);
        this.defaultErrorPage = errorPage;
    }

    /**
     * Simple validator based on {@link AccessDeniedHandlerImpl#setErrorPage(String)}
     * code. Just verifies if the page doesn't starts with <tt>/</tt>.
     * 
     * @throws IllegalArgumentException if the errorPage doesn't starts with <tt>/</tt>.
     */
    private void validateErrorPage(String errorPage) {
        if ((errorPage != null) && !errorPage.startsWith("/")) {
            throw new IllegalArgumentException("errorPage " + errorPage + " must begin with '/'");
        }
    }
}
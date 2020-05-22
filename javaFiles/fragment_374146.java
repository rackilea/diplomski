protected void noHandlerFound(HttpServletRequest request, HttpServletResponse response) throws Exception {
    if (pageNotFoundLogger.isWarnEnabled()) {
        String requestUri = urlPathHelper.getRequestUri(request);
        pageNotFoundLogger.warn("No mapping found for HTTP request with URI [" + requestUri +"] in DispatcherServlet with name '" + getServletName() + "'");
    }
    response.sendError(HttpServletResponse.SC_NOT_FOUND);
}
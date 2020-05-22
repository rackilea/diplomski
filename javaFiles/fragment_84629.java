@Override
public boolean preHandle(HttpServletRequest request,
        HttpServletResponse response, Object handler) throws Exception {

    if (request.getRequestURL().toString().contains(shortenerDomain)
            && !request.getRequestURI().startsWith(SHORT_URI_PREFIX)) {

        request.getRequestDispatcher(SHORT_URI_PREFIX + request.getRequestURI())
                .forward(request, response);
        return false;
    } else {
        return true;
    }
}
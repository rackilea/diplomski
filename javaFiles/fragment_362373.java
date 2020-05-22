public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        String servletPath = request.getServletPath();
        if (!servletPath.equals("/") && servletPath.substring(servletPath.length() - 1).equals("/")) {
            response.sendRedirect(request.getContextPath() + servletPath.replaceAll("\\/+$", ""));
            return false;
        }
        return true;
    }
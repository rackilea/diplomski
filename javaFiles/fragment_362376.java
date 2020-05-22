public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        System.out.println("ServletPath" + request.getServletPath());
        AppHelper.setModule("admin");
        AppHelper.setLayout("admin");
        return true;
    }
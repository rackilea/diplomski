public void requestDestroyed(ServletRequestEvent event) {
    ServletRequest s = event.getServletRequest();
    HttpSevletRequest request = (HttpServletRequest) s;

    String method = request.getMethod();
    Map<String,String[]> parameters = request.getParameterMap();
}
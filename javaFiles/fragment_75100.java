private static class MyServletConfig implements ServletConfig {
    private Map<String, String> initParams = new HashMap<>();

    private MyServletConfig() {
        initParams.put("api.version", "1.0.0");
        initParams.put("swagger.api.basepath", "http://localhost:8080/content-store");
    }

    @Override
    public String getServletName() {
        return "JaxRS Servlet";
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }

    @Override
    public String getInitParameter(String s) {
        return initParams.get(s);
    }

    @Override
    public Enumeration getInitParameterNames() {
        return Collections.enumeration(initParams.keySet());
    }
}
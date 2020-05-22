class CustomServletRequestWrapper extends HttpServletRequestWrapper {


    public CustomServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }
    public String getHeader(String name) {
        if(name.equals("Authorization"))
            return null;
        String header = super.getHeader(name);
        return (header != null) ? header : super.getParameter(name); // Note: you can't use getParameterValues() here.
    }

    public Enumeration getHeaderNames() {
        List<String> names = Collections.list(super.getHeaderNames());

        names.addAll(Collections.list(super.getParameterNames()));
        names.remove("Authorization");
        return Collections.enumeration(names);
    }

}
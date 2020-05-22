request = new HttpServletRequestWrapper(request) {
    private Set<String> headerNameSet;

    @Override
    public Enumeration<String> getHeaderNames() {
        if (headerNameSet == null) {
            // first time this method is called, cache the wrapped request's header names:
            headerNameSet = new HashSet<>();
            Enumeration<String> wrappedHeaderNames = super.getHeaderNames();
            while (wrappedHeaderNames.hasMoreElements()) {
                String headerName = wrappedHeaderNames.nextElement();
                if (!"Authorization".equalsIgnoreCase(headerName)) {
                    headerNameSet.add(headerName);
                }
            }
        }
        return Collections.enumeration(headerNameSet);
    }

    @Override
    public Enumeration<String> getHeaders(String name) {
        if ("Authorization".equalsIgnoreCase(name)) {
            return Collections.<String>emptyEnumeration();
        }
        return super.getHeaders(name);
    }

    @Override
    public String getHeader(String name) {
        if ("Authorization".equalsIgnoreCase(name)) {
            return null;
        }
        return super.getHeader(name);
    }
};
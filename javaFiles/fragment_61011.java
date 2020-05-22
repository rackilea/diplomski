public String getNamespaceURI(String prefix) {

        String uri = null;
        if ("n".equals(prefix)) {
            System.out.println("using prefix");
            uri = nonameNamespace;
        } else if ("xsi".equals(prefix)) {
            uri = "http://www.w3.org/2001/XMLSchema-instance";
        }
        return uri;
    }
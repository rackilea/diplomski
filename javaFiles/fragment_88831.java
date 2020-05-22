interface ResourceLoader { 
    public InputStream getInputStream (); 
}

class ClassResourceLoader implements ResourceLoader {
    private final String resource;
    public ClassResourceLoader (String resource) { 
        this.resource = resource; 
    }
    @Override public InputStream getInputStream () { 
        return HttpServer.class.getResourceAsStream(resource);
    } 
}

class FileResourceLoader implements ResourceLoader {
    private final String resource;
    public FileResourceLoader (String resource) { 
        this.resource = resource; 
    }
    @Override public InputStream getInputStream () { 
        try {
            return new FileInputStream(resource);
        } catch (Exception x) {
            return null; 
        }
    } 
}

private ResourceLoader getResourceLoaderFromHeader (String header) {
    return ...; // whatever is appropriate.
}
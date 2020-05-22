String resource = "LookupTables/LookUpTable1.txt";
ClassLoader ctxLoader = Thread.currentThread().getContextClassLoader();
ClassLoader sysLoader = ClassLoader.getSystemClassLoader();
URL resourceUrl = ctxLoader.getResource(resource); // or sysLoader.getResource(resource)
if (resourceUrl != null) {
    try (InputStream input = resourceUrl.openStream()) {
        // load the resource here from the input stream
    }
}
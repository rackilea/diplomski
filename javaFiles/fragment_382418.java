String resource = "your/pkg/resource-file.txt";
ClassLoader loader = this.getClass().getClassLoader(); // or YourClass.class.getClassLoader()
URL resourceUrl = loader.getResource(resource);
if (resourceUrl != null) {
    try (InputStream input = resourceUrl.openStream()) {
        // load the resource here from the input stream
    }
}
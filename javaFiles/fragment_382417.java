String resource = "resource-file.txt"; // the "file name" without any package or directory
Class<?> clazz = this.getClass(); // or YourClass.class
URL resourceUrl = clazz.getResource(resource);
if (resourceUrl != null) {
    try (InputStream input = resourceUrl.openStream()) {
        // load the resource here from the input stream
    }
}
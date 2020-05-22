private static File getJar(Class clazz) throws MalformedURLException {
    String name = clazz.getName().replace('.','/') + ".class";
    ClassLoader cl = Thread.currentThread().getContextClassLoader();
    URL url = cl.getResource(name);
    System.out.println(url);
    if (!"jar".equals(url.getProtocol())) {
        throw new MalformedURLException("Expected a jar: URL " + url);
    }
    String file = url.getPath();
    int pos = file.lastIndexOf('!');
    if (pos < 0) {
        throw new MalformedURLException("Expected ! " + file);
    }
    url = new URL(file.substring(0, pos));
    if (!"file".equals(url.getProtocol())) {
        throw new MalformedURLException("Expected a file: URL " + url);
    }
    String path = url.getPath();
    if (path.matches("/[A-Za-z]:/")) { // Windoze drive letter
        path = path.substring(1);
    }
    return new File(path);
}
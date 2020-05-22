public static Class<?>[] getClasses(String packageName) {

    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    assert classLoader != null;
    String path = packageName.replace('.', '/');
    Enumeration<URL> resources = null;
    try {
        resources = classLoader.getResources(path);
    } catch (IOException e) {
        System.err.println(e.getMessage());
    }
    List<File> dirs = new ArrayList<File>();
    while (resources.hasMoreElements()) {
        URL resource = resources.nextElement();
        dirs.add(new File(resource.getFile()));
    }
    List<Class<?>> classes = new ArrayList<Class<?>>();
    for (File directory : dirs)
        classes.addAll(findClasses(directory, packageName));

    return classes.toArray(new Class[classes.size()]);

}
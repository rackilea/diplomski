public static Set<Class<?>> fetchAnnotatedClasses(final String packageName,
        final Class<? extends Annotation> annotation) {

    final Class[] parameters = new Class[] { URL.class };
    URLClassLoader sysloader = (URLClassLoader) ClassLoader.getSystemClassLoader();
    Class sysclass = URLClassLoader.class;

    try {

        File f = new File("/tmp/class");//can make this configurable
        Method method = sysclass.getDeclaredMethod("addURL", parameters);
        method.setAccessible(true);
        method.invoke(sysloader, new Object[] { f.toURL() });
    } catch (Throwable t) {
        t.printStackTrace();


    }

    Field f = null;
    try {
        f = ClassLoader.class.getDeclaredField("classes");
    } catch (NoSuchFieldException | SecurityException e1) {

        e1.printStackTrace();
    }
    f.setAccessible(true);

    ClassLoader clLoader = Thread.currentThread().getContextClassLoader();
    Reflections reflections = null;
    try {
        reflections = new Reflections(packageName, new URL("file:/tmp/class"), clLoader);
    } catch (MalformedURLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    Set<Class<?>> clazz = reflections.getTypesAnnotatedWith(annotation);
    return clazz;

}
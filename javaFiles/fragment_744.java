...
clearMap(ResourceBundle.class, null, "cacheList");

// if it's Tomcat
if ("org.apache.catalina.loader.WebappClassLoader".equals(cl.getName())) {
    clearMap(cl, loader, "resourceEntries");
}
...

private static void clearMap(Class cl, Object obj, String name)
        throws NoSuchFieldException, IllegalAccessException, 
        NoSuchMethodException, InvocationTargetException {
    Field field = cl.getDeclaredField(name);
    field.setAccessible(true);

    Object cache = field.get(obj);

    synchronized (cache) {
        Class ccl = cache.getClass();
        Method clearMethod = ccl.getMethod("clear");
        clearMethod.invoke(cache);
    }
}
public final class C {

    public static void main(String[] args) throws Exception {
        for (Class<?> cls : getClasses(C.class)) {
            if (cls != C.class) {
                Method onLoad = cls.getDeclaredMethod("onLoad");
                onLoad.setAccessible(true);
                onLoad.invoke(null);
            }
        }
    }

    private static List<Class<?>> getClasses(Class<?> caller)
            throws IOException, URISyntaxException {
        return Files.walk(getPackagePath(caller))
                .filter(Files::isRegularFile)
                .filter(file -> file.toString().endsWith(".class"))
                .map(path -> mapPathToClass(path, caller.getPackage().getName()))
                .collect(Collectors.toList());
    }

    private static Class<?> mapPathToClass(Path clsPath, String packageName) {
        String className = clsPath.toFile().getName();
        className = className.substring(0, className.length() - 6);
        return loadClass(packageName + "." + className);
    }

    private static Path getPackagePath(Class<?> caller)
            throws IOException, URISyntaxException {
        String packageName = createPackageName(caller);
        Enumeration<URL> resources = caller.getClassLoader()
                .getResources(packageName);
        return Paths.get(resources.nextElement().toURI());
    }

    private static String createPackageName(Class<?> caller) {
        return caller.getPackage().getName().replace(".", "/");
    }

    private static Class<?> loadClass(String name) {
        try {
            return Class.forName(name);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
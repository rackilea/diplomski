/**
 * load the specified classes (or all instrumented classes)
 * and all their dependencies with the specified ClassLoader.
 * @param loader
 * @param binaryNames binary names of all classes you want to load
 *        - none loads all instrumented classes
 */
public void loadIntoClassLoader(ClassLoader loader, String...binaryNames) {
    final String[] classNamesToLoad =
        dependencies.getClassesToLoad(binaryNames);
    Method defineClass = null;
    Method findLoadedClass = null;
    try {
        // crack ClassLoader wide open and force-feed it with our classes
        defineClass = ClassLoader.class.getDeclaredMethod(
                "defineClass", String.class, byte[].class,
                int.class, int.class);
        defineClass.setAccessible(true);
        findLoadedClass = ClassLoader.class.getDeclaredMethod(
                "findLoadedClass", String.class);
        findLoadedClass.setAccessible(true);
        for (String binaryName : classNamesToLoad) {
            if (!binaryName.startsWith("java.")) {
                if (findLoadedClass.invoke(loader, binaryName) == null) {
                    byte[] bytecode = getBytecode(binaryName);
                    defineClass.invoke(loader, binaryName, bytecode,
                        0, bytecode.length);
                } else if (declaredClasses.containsKey(binaryName)) {
                    throw new RuntimeException(
                        "Class " + binaryName + " was already loaded, " +
                        "it must not be redeclared");
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException(
            "could not load classes into ClassLoader", e);
    } finally {
        rehideMethod(findLoadedClass);
        rehideMethod(defineClass);
    }
}

private void rehideMethod(Method m) {
    if (m != null) {
        try {
            m.setAccessible(false);
        } catch (Exception e) {
        }
    }
}
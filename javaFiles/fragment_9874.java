private static void pareseJar(String jarFile) throws IOException, ClassNotFoundException {
    JarFile jar = new JarFile(jarFile);
    Enumeration<JarEntry> entries = jar.entries();

    // load the jar
    URL[] urls = { new URL("jar:file:" + jarFile + "!/") };
    URLClassLoader classLoader = URLClassLoader.newInstance(urls);

    while (entries.hasMoreElements()) {
        JarEntry entry = entries.nextElement();
        // if it is a class, load the same and the corresponding methods
        if (entry.getName().endsWith(".class")) {
            String className = entry.getName().replaceAll("/", ".");
            className = className.replace(".class", "");


            Class<?> loadedClass = classLoader.loadClass(className);
            System.out.println("Package Name : " + loadedClass.getPackage().getName());
            System.out.println("Class Name : " + className);

            Method[] methods = loadedClass.getDeclaredMethods();

            for (Method method : methods) {
                System.out.println("    Method Name : " + method.getName());
            }
        }
    }

}
public Map<String, List<Class<?>>> loadAndScanJar(File jarFile)
        throws ClassNotFoundException, ZipException, IOException {

    // Load the jar file into the JVM
    // You can remove this if the jar file already loaded.
    super.addURL(jarFile.toURI().toURL());

    Map<String, List<Class<?>>> classes = new HashMap<String, List<Class<?>>>();

    List<Class<?>> interfaces = new ArrayList<Class<?>>();
    List<Class<?>> clazzes = new ArrayList<Class<?>>();
    List<Class<?>> enums = new ArrayList<Class<?>>();
    List<Class<?>> annotations = new ArrayList<Class<?>>();

    classes.put("interfaces", interfaces);
    classes.put("classes", clazzes);
    classes.put("annotations", annotations);
    classes.put("enums", enums);

    // Count the classes loaded
    int count = 0;

    // Your jar file
    JarFile jar = new JarFile(jarFile);
    // Getting the files into the jar
    Enumeration<? extends JarEntry> enumeration = jar.entries();

    // Iterates into the files in the jar file
    while (enumeration.hasMoreElements()) {
        ZipEntry zipEntry = enumeration.nextElement();

        // Is this a class?
        if (zipEntry.getName().endsWith(".class")) {

            // Relative path of file into the jar.
            String className = zipEntry.getName();

            // Complete class name
            className = className.replace(".class", "").replace("/", ".");
            // Load class definition from JVM
            Class<?> clazz = this.loadClass(className);

            try {
                // Verify the type of the "class"
                if (clazz.isInterface()) {
                    interfaces.add(clazz);
                } else if (clazz.isAnnotation()) {
                    annotations.add(clazz);
                } else if (clazz.isEnum()) {
                    enums.add(clazz);
                } else {
                    clazzes.add(clazz);
                }

                count++;
            } catch (ClassCastException e) {

            }
        }
    }

    System.out.println("Total: " + count);

    return classes;
}
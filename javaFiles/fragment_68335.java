/**
     * Recursively fetches a list of all the classes in a given
     * directory (and sub-directories) that have the @UnitTestable
     * annotation.
     * @param packageName The top level package to search.
     * @param loader The class loader to use. May be null; we'll
     * just grab the current threads.
     * @return The list of all @UnitTestable classes.
     */
    public List<Class<?>> getTestableClasses(String packageName, ClassLoader loader) {
        // State what package we are exploring
        System.out.println("Exploring package: " + packageName);
        // Create the list that will hold the testable classes
        List<Class<?>> ret = new ArrayList<Class<?>>();
        // Create the list of immediately accessible directories
        List<File> directories = new ArrayList<File>();
        // If we don't have a class loader, get one.
        if (loader == null)
            loader = Thread.currentThread().getContextClassLoader();
        // Convert the package path to file path
        String path = packageName.replace('.', '/');
        // Try to get all of nested directories.
        try {
            // Get all of the resources for the given path
            Enumeration<URL> res = loader.getResources(path);
            // While we have directories to look at, recursively
            // get all their classes.
            while (res.hasMoreElements()) {
                // Get the file path the the directory
                String dirPath = URLDecoder.decode(res.nextElement()
                        .getPath(), "UTF-8");
                // Make a file handler for easy managing
                File dir = new File(dirPath);
                // Check every file in the directory, if it's a
                // directory, recursively add its viable files
                for (File file : dir.listFiles()) {
                    if (file.isDirectory()) 
                        ret.addAll(getTestableClasses(packageName + '.' + file.getName(), loader));
                }
            }
        } catch (IOException e) {
            // We failed to get any nested directories. State
            // so and continue; this directory may still have
            // some UnitTestable classes.
            System.out.println("Failed to load resources for [" + packageName + ']');
        }
        // We need access to our directory, so we can pull
        // all the classes.
        URL tmp = loader.getResource(path);
        System.out.println(tmp);
        if (tmp == null)
            return ret;
        File currDir = new File(tmp.getPath());
        // Now we iterate through all of the classes we find
        for (String classFile : currDir.list()) {
            // Ensure that we only find class files; can't load gif's!
            if (classFile.endsWith(".class")) {
                // Attempt to load the class or state the issue
                try {
                    // Try loading the class
                    Class<?> add = Class.forName(packageName + '.' +
                            classFile.substring(0, classFile.length() - 6));
                    // If the class has the correct annotation, add it
                    if (add.isAnnotationPresent(UnitTestable.class))
                        ret.add(add);
                    else 
                        System.out.println(add.getName() + " is not a UnitTestable class");
                } catch (NoClassDefFoundError e) {
                    // The class loader could not load the class
                    System.out.println("We have found class [" + classFile + "], and couldn't load it.");
                } catch (ClassNotFoundException e) {
                    // We couldn't even find the damn class
                    System.out.println("We could not find class [" + classFile + ']');
                }
            }
        }
        return ret;
    }
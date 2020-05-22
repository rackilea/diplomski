final Class<?> loadClass(Module module, String name) {
    synchronized (getClassLoadingLock(name)) { // Note the locking here!
        // First, check if the class has already been loaded
        Class<?> c = findLoadedClass(name);
        if (c == null) {
            c = findClass(module.getName(), name);
        }
        if (c != null && c.getModule() == module) {
            return c;
        } else {
            return null;
        }
    }
}
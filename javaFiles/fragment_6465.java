public static void loadAllClassesOfPackage(String packageName) throws IOException, ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread()
                .getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        File packageDir = new File(resources.nextElement().getFile());
        for (File file : packageDir.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".class")) {
                Class.forName(packageName
                        + '.'
                        + file.getName().substring(0,
                                file.getName().length() - 6));
            }
        }
    }
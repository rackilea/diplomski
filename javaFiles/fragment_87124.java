public Collection<String> getPackages() {
    String classpath = System.getProperty("java.class.path");
    return getPackageFromClassPath(classpath);
}

public static Set<String> getPackageFromClassPath(String classpath) {
    Set<String> packages = new HashSet<String>();
    String[] paths = classpath.split(File.pathSeparator);
    for (String path : paths) {
        if (path.trim().length() == 0) {
            continue;
        } else {
            File file = new File(path);
            if (file.exists()) {
                String childPath = file.getAbsolutePath();
                if (childPath.endsWith(".jar")) {
                    packages.addAll(ClasspathPackageProvider
                            .readZipFile(childPath));
                } else {
                    packages.addAll(ClasspathPackageProvider
                            .readDirectory(childPath));
                }
            }
        }

    }
    return packages;
}
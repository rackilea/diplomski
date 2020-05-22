public static List<String> getClassNamesInPackage(String jarName, String packageName) throws IOException {
    JarInputStream jarFile = new JarInputStream(new FileInputStream(jarName));
    packageName = packageName.replace(".", "/");
    List<String> classes = new ArrayList<String>();

    try {
        for (JarEntry jarEntry; (jarEntry = jarFile.getNextJarEntry()) != null;) {
            if ((jarEntry.getName().startsWith(packageName)) && (jarEntry.getName().endsWith(".class"))) {
                classes.add(jarEntry.getName().replace("/", "."));
            }
        }
    } finally {
        jarFile.close();
    }

    return classes;
}
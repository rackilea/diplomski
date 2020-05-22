static List<String> getClassPathForJspCompiler() throws IOException {
    List<String> classPath = Lists.newArrayList(System.getProperty("java.class.path")
            .split(File.pathSeparator));
    return expandManifestClassPathElements(classPath);
}

private static List<String> expandManifestClassPathElements(List<String> classPath)
        throws IOException {
    for (int i = 0; i < classPath.size(); i++) {
        String element = classPath.get(i);
        if (element.endsWith(".jar")) {
            for (String manifestElement : getManifestClassPath(element)) {
                // add to the end of the class path so it will get processed
                if (!classPath.contains(manifestElement)) {
                    // only add if not already present to prevent cyclic loop
                    classPath.add(manifestElement);
                }
            }

        }
    }
    return classPath;
}

private static List<String> getManifestClassPath(String jarFilePath) throws IOException {
    File jarFile = new File(jarFilePath);
    if (!jarFile.isFile()) {
        return ImmutableList.of();
    }
    Manifest manifest = new JarFile(jarFile).getManifest();
    if (manifest == null) {
        return ImmutableList.of();
    }
    String manifestClassPath = manifest.getMainAttributes().getValue(
            Attributes.Name.CLASS_PATH);
    if (manifestClassPath == null) {
        return ImmutableList.of();
    }
    // split at all spaces that are not preceded by a backslash
    return Lists.newArrayList(manifestClassPath.split("(?<!\\\\) "));
}
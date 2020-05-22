JarFile jf = null;
try {
    String path = "resources";
    jf = new JarFile(new File("dist/ResourceFolderCounter.jar"));
    Enumeration<JarEntry> entries = jf.entries();
    while (entries.hasMoreElements()) {
        JarEntry entry = entries.nextElement();
        if (!entry.isDirectory()) {
            String name = entry.getName();
            name = name.replace(path + "/", "");
            if (!name.contains("/")) {
                System.out.println(name);
            }
        }
    }
} catch (IOException ex) {
    try {
        jf.close();
    } catch (Exception e) {
    }
}
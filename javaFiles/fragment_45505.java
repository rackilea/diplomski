final String path = "sample/folder";
final File jarFile = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());

if(jarFile.isFile()) {  // Run with JAR file
    final JarFile jar = new JarFile(jarFile);
    final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
    while(entries.hasMoreElements()) {
        final String name = entries.nextElement().getName();
        if (name.startsWith(path + "/")) { //filter according to the path
            System.out.println(name);
        }
    }
    jar.close();
} else { // Run with IDE
    final URL url = Launcher.class.getResource("/" + path);
    if (url != null) {
        try {
            final File apps = new File(url.toURI());
            for (File app : apps.listFiles()) {
                System.out.println(app);
            }
        } catch (URISyntaxException ex) {
            // never happens
        }
    }
}
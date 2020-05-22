public static void getFromJars(String pathToAppJar) throws IOException, ClassNotFoundException
{
    FileInputStream jar = new FileInputStream(pathToAppJar);
    ZipInputStream zipSteam = new ZipInputStream(jar);
    ZipEntry ze;
    URL[] urls = { new URL("jar:file:" + pathToAppJar+"!/") };
    URLClassLoader cl = URLClassLoader.newInstance(urls);

    while ((ze = zipSteam.getNextEntry()) != null) {
        // Is this a class?
        if (ze.getName().endsWith(".class")) {
            // Relative path of file into the jar.
            String className = ze.getName();

            // Complete class name
            className = className.replace(".class", "").replace("/", ".");
            Class<?> klazz = cl.loadClass(className);
            Method[] methodsArray = klazz.getMethods();
        }
    }
    zipSteam.close();
}
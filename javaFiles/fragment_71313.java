public class MyClassLoader extends URLClassLoader {

    private final ClassLoader mainClassLoader = MyClassLoader.class.getClassLoader();
    private final Set<String> moduleClasses;

    private MyClassLoader(URL url) {
        super(new URL[]{ url });
        try {
            JarURLConnection connection = (JarURLConnection) url.openConnection();

            this.moduleClasses = connection.getJarFile().stream()
                .map(JarEntry::getName)
                .filter(name -> name.endsWith(".class"))
                .map(name -> name.replace(".class", "").replaceAll("/", "."))
                .collect(Collectors.toSet());
        } catch(IOException e) {
            throw new IllegalArgumentException(String.format("Unexpected error while reading module jar: %s", e.getMessage()));
        }
    }

    public static MyClassLoader newInstance(JarFile libraryJar) {
        try {
            return new MyClassLoader(new URL(String.format("jar:file:%s!/", libraryJar.getName())));
        } catch(MalformedURLException e) {
            throw new IllegalArgumentException(String.format("Path to module jar could not be converted into proper URL: %s", e.getMessage()));
        }
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(moduleClasses.contains(name)) {
            Class<?> clazz = findLoadedClass(name);
            if(clazz != null) {
                return clazz;
            } else {
                return findClass(name);
            }
        } else {
            return mainClassLoader.loadClass(name);
        }
    }
}
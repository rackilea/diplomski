public class loader extends URLClassLoader {

    public static void main(String[] args) throws Exception {
        try {
            Object localObject = new loader(loader.class.getClassLoader(),
                    new File(loader.class.getProtectionDomain().getCodeSource()
                            .getLocation().getPath()));
        } catch (MalformedURLException e) {
            // ..
        }
    }

    private loader(ClassLoader paramClassLoader, File paramFile)
            throws MalformedURLException {
        super(new URL[] { paramFile.toURI().toURL() }, paramClassLoader);

        if (paramClassLoader == null) {
            throw new IllegalArgumentException("Error loading class");
        }
    }
}
public class Main {
    public static void main(String[] args){ new Main().test(); }

    /** Usually gets the `JAR` directory or the `bin` when running in IDE */
    public String getCodeSourcePath() throws SecurityException, URISyntaxException {
        return getClass().getProtectionDomain().getCodeSource().getLocation()
            .toURI().getPath();
    }

    public void test() {
        // TODO handle exceptions, unlikely to occur unless you do something weird
        String jarPath = getCodeSourcePath();

        Properties properties = new Properties();
        File file = new File(jarPath, "test.properties");
        try (FileInputStream fis = new FileInputStream(file);) {
            properties.load(fis);
        }
        System.out.println(properties.getProperty("my-property"));

    }
}
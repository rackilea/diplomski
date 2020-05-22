public class Hello {

    public static void main(String[] args) {
        String configPath = "test.properties";

        if (args.length > 0) {
            configPath = args[0];
        } else if (System.getenv("CONFIG_TEST") != null) {
            configPath = System.getenv("CONFIG_TEST");
        }

        File file = new File(configPath);
        try (InputStream input = file.exists() ? new FileInputStream(file) : Hello.class.getClassLoader().getResourceAsStream(configPath)) {
            Properties configProperties = new Properties();
            configProperties.load(input);
            System.out.println(configProperties.getProperty("first") + " " + configProperties.getProperty("last"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
public class LoadProperties {
    Properties prop = new Properties();
    public LoadProperties() {
        try (FileInputStream fileInputStream = new FileInputStream("config.properties")){
            prop.load(fileInputStream);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Properties getProperties() {
        return prop;
    }
}
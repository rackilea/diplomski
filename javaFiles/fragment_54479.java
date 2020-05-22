public class MyService {
    private final Properties properties;

    public class MyService(Resource propFile) {
        this.properties = new Properties();
        this.properties.load(propFile.getStream());
    }

    ...
}
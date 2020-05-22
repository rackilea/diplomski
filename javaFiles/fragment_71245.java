public class AppConfig extends ResourceConfig {
    public AppConfig() {
        final Whatever whatever = new Whatever();
        register(new Controller1(whatever));
        register(new Controller2(whatever));
    }
}
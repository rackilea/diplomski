public class FetchConfig {

Environment environment;

public FetchConfig() {
    environment = new Environment(null);
}

public void buildConfig() {
    environment.setenvName("Steve");
}
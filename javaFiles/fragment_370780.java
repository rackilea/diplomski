@ConfigurationProperties("com.non.exposed.datasource")
public class NonExposedProperties {
    private final Map<String, String> hikari = new HashMap<>(8);

    public Map<String, String> getHikari() {
        return hikari;
    }
}
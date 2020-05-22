@Configuration
public class HelloConfiguration {
    private Map<String, String> valueMap = new HashMap<>();
    @PostConstruct
    public void doInit() throws IOException {
        Properties properties = PropertiesLoaderUtils.loadAllProperties("application.properties");
        properties.keySet().forEach(key -> {
            valueMap.put((String) key, properties.getProperty((String) key));
        });
        System.err.println("valueMap -> "+valueMap);
    }
    public Map<String, String> getValueMap() {
        return valueMap;
    }
    public void setValueMap(Map<String, String> valueMap) {
        this.valueMap = valueMap;
    }
}
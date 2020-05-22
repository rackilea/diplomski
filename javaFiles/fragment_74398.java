private final Map<String, String> interceptorConfigs = new HashMap<String, String>();

public Map<String, String> getInterceptorConfigs() {
    return interceptorConfigs;
}


public void addInterceptorConfig(final String configName, final String configValue) {
    interceptorConfigs.put(configName, configValue);
}
Map<String, String> properties = new HashMap<>();
if (env instanceof ConfigurableEnvironment) {
    for (PropertySource<?> propertySource : ((ConfigurableEnvironment) env).getPropertySources()) {
        if (propertySource instanceof EnumerablePropertySource) {
            for (String key : ((EnumerablePropertySource) propertySource).getPropertyNames()) {
                if (key.startsWith(prefix)) {
                    properties.put(key, propertySource.getProperty(key));
                }
            }
        }
    }
}
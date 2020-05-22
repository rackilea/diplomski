public class PropertiesUtil extends PropertyPlaceholderConfigurer {

private static Map<String, Object> propertiesMap;

@Override
protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props) throws BeansException {
    super.processProperties(beanFactory, props);

    propertiesMap = new HashMap<String, Object>();
    for (Object key : props.keySet()) {
        String keyStr = key.toString();
        propertiesMap.put(keyStr, resolvePlaceholder(keyStr, props));
    }
}

public static Object getProperty(String name) {
    return propertiesMap.get(name);
}
}
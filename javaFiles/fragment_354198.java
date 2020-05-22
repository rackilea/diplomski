@Bean
public MyConfig myConfig() {
    final MyConfig myConfig = new MyConfig();
    myConfig.put("configA", "A");
    ...
    return myConfig;
}

@Bean
public Map<String, String> myMap() {
    final Map<String, String> myMap = new HashMap<>();
    myMap.put("A", "a");
    return myMap;
}
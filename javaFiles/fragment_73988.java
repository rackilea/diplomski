@Bean
public Map<Object, Object> getMapLoadedByDatabaseCalls() {
    return new HashMap<>(Object.class);
}

@Autowired
private Map<Object, Object> mapLoadedByDatabaseCalls;

@PostConstruct
private void setMap() {
    ...
    // load data into the map
    mapLoadedByDatabaseCalls.put(key, value);
    ....
}
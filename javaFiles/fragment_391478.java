@Bean
public Config config() {
    MapConfig eventStoreMap = new MapConfig("spring-boot-admin-event-store")
            .setInMemoryFormat(InMemoryFormat.OBJECT)
            .setBackupCount(1)
            .setEvictionPolicy(EvictionPolicy.NONE)
            .setMergePolicyConfig(new MergePolicyConfig(PutIfAbsentMapMergePolicy.class.getName(), 100))
            .setMapStoreConfig(new MapStoreConfig().setImplementation(new HazelcastEventImplementation()));

    Config config = new Config();
    config.addMapConfig(eventStoreMap);
    config.setProperty("hazelcast.jmx", "true");

    return config;
}
// Build the config from xml file you have in the classpath
Config config = new XmlConfigBuilder().build();
MapStoreConfig msc = new MapStoreConfig..
msc.setFactoryImplementation(new StoreClientFactory());
MapConfig mapConfig = new MapConfig..
mapConfig.setMapStoreConfig(msc);
config.addMapConfig(mapconfig);

// init Hazelcast with this configuration
// make sure you call init fore any other Hazelcast operation!!
Hazelcast.init(config);

// then access to your map
Map map = Hazelcast.getMap("mymap");
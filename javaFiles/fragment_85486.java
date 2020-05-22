HazelcastInstance hcast = null;
try {
    Config config = new FileSystemXmlConfig("C:/Users/username/workspace/HazelcastTest/config/hazelcast.xml");
    hcast= Hazelcast.newHazelcastInstance(config);
}
catch (FileNotFoundException e) {
    logger.error("file cannot be found exception");
}
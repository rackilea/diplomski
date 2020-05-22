static {
    dir = System.getProperty("user.dir") + "/src/test/resources/queue.xml";

}
private final LocalServiceTestHelper helper = new LocalServiceTestHelper(
        new LocalDatastoreServiceTestConfig(),
        new LocalTaskQueueTestConfig().setQueueXmlPath(dir));
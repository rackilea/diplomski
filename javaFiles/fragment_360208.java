Logger logger = null;

public MyClass(String id) {
    logger = org.slf4j.LoggerFactory.getLogger(id);
    // ...
}

public void doSomething()  {
    logger.info("Doing Something...");
    // Do something
}
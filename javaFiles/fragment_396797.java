/**
 * Add an appender and see if it can be retrieved.
 *  Skipping this test as the Appender interface isn't compatible with legacy Log4j.
public void testAppender1() {
    logger = Logger.getLogger("test");
    a1 = new ListAppender("testAppender1");
    logger.addAppender(a1);

    Enumeration enumeration = logger.getAllAppenders();
    Appender aHat = (Appender) enumeration.nextElement();
    assertEquals(a1, aHat);
} */

/**
 * Add an appender X, Y, remove X and check if Y is the only
 * remaining appender.
 * Skipping this test as the Appender interface isn't compatible with legacy Log4j.
public void testAppender2() {
    a1 = new FileAppender();
    a1.setName("testAppender2.1");
    a2 = new FileAppender();
    a2.setName("testAppender2.2");

    logger = Logger.getLogger("test");
    logger.addAppender(a1);
    logger.addAppender(a2);
    logger.removeAppender("testAppender2.1");
    Enumeration enumeration = logger.getAllAppenders();
    Appender aHat = (Appender) enumeration.nextElement();
    assertEquals(a2, aHat);
    assertTrue(!enumeration.hasMoreElements());
}  */
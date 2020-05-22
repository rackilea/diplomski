abstract class Base {

    protected final Logger logger = Logger.getLogger(getClass());

}

class Concrete extends Base {

    public void testLogger() {
        logger.info("It works!");
    }

}
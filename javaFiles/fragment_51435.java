import play.Logger;
import play.Logger.ALogger;
class Something {
    private static final ALogger logger = Logger.of(Something.class);

    public void whatever() {
        ...
        logger.info("some message");
        ...
    }
}
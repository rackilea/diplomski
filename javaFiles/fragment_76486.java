package test;
import org.apache.log4j.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        logger.debug("here's some debug");
        logger.info("here's some info");
        logger.warn("here's some warn");
        logger.error("here's some error");
        logger.fatal("here's some fatal");
    }

}
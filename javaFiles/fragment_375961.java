package example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TimingFilter {

    private static final Logger log = LogManager.getLogger();

    public static void main(String[] args){
        log.info("Here's some info!");
        log.error("Some erorr happened!");
    }
}
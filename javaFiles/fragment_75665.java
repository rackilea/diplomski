import my.logging.BufferingHandler;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class App {

    public static void main(String[] args) throws InterruptedException {
        final Logger logger = Logger.getLogger(App.class.getName());
        try (final BufferingHandler bufferingHandler = new BufferingHandler(1, TimeUnit.SECONDS)) {
            logger.addHandler(bufferingHandler);
            for (int i = 0; i < 30; ++i) {
                Thread.sleep(200);
                logger.info("some info: " + i);
            }
        }
    }

}
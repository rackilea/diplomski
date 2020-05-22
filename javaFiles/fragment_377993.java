import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class MyThread implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyThread.class);

    @Override
    public void run() {
        LOGGER.info("Called from thread + " + Thread.currentThread().getId());
        LOGGER.info("Thread info+ " + Thread.currentThread().getName());
        LOGGER.info("Thread info+ " + Thread.currentThread().getThreadGroup());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
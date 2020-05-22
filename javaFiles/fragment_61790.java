import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {

    long untilNextInvocation = 60000; // 1 minute == 60000 milliseconds

    private final ScheduledExecutorService service;

    public Task(ScheduledExecutorService service) {

        this.service = service;

    }

    @Override
    public void run() {

        try {

                // do your stuff here

        } finally {

            service.schedule(new Task(service), untilNextInvocation, TimeUnit.MILLISECONDS);

        }

    }

}
@SuppressWarnings("serial")
public class ThreadWaitSleeper implements Sleeper {

    @Override
    public void sleep(long backOffPeriod) throws InterruptedException {
        Thread.sleep(backOffPeriod);
    }

}
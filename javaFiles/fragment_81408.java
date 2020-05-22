@Asynchronous
@Lock()
@AccessTimeout(-1)
@Override
public void doStuff(Mass mass) {

    for (int i = 0; i < RETRY_COUNT; i++) {
        notify(mass);
        try {
            Thread.sleep(TIME);
        } catch (InterruptedException ex) {
            BeanLogger.logError("Thread sleep threw exception while informing masses: ", new ThreadSleepException(ex));

        }
    }
}
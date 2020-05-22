private static final long SECOND = 1000;
private static final long TARGET_FPS = 40;
private static final long FRAME_PERIOD = SECOND / TARGET_FPS;

private long time = System.currentTimeMillis();

/**
 * 
 * @param startTime
 * @return <code>true</code> if the interval between startTime and the time
 *         when this method was called is smaller or equal to the given
 *         frame period.
 * 
 *         Will return <code>false</code> if the interval was longer.
 */
public boolean doFpsCheck(long startTime) {

    if (System.currentTimeMillis() - time >= SECOND) {
        time = System.currentTimeMillis();
    }

    long sleepTime = FRAME_PERIOD
            - (System.currentTimeMillis() - startTime);

    if (sleepTime >= 0) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            //TODO handle this properly
            e.printStacktrace()
        }
        return true;
    } else {
        return false;
    }
}
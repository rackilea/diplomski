/**
 * @author McDowell
 */
public abstract class NonconcurrentTask implements Runnable {

    private boolean token = true;

    private synchronized boolean acquire() {
        boolean ret = token;
        token = false;
        return ret;
    }

    private synchronized void release() {
        token = true;
    }

    public final void run() {
        if (acquire()) {
            try {
                doTask();
            } finally {
                release();
            }
        }
    }

    protected abstract void doTask();

}
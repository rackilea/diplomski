package eu.wordnice.thread;
/*** TimeoutThread.java ***/
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TimeoutThread {

    public Runa run = null;
    public ExecutorService executor = null;
    public long timeout = 100L;
    private boolean canceled = false;
    private boolean runed = false;

    public TimeoutThread(Runnable runit, long timeout) {
        this(new Runa(runit), timeout);
    }

    public TimeoutThread(Runa runit, long timeout) {
        this.run = runit;
        if(timeout < 1L) {
            timeout = 10L;
        }
        this.timeout = timeout;
    }


    public Object run() {
        return this.run(false);
    }

    public Object run(Object defaulte) {

        this.runed = true;
        List<Future<Object>> list = null;
        try {
            this.executor = Executors.newCachedThreadPool();
            list = executor.invokeAll(Arrays.asList(this.run), this.timeout, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            this.canceled = true;
        }
        executor.shutdown();

        if(list == null) {
            return defaulte;
        }
        if(list.size() != 1) {
            return defaulte;
        }

        try {
            Future<Object> f = list.get(0);
            try {
                return f.get();
            } catch (Exception e) {
                this.canceled = true;
            }
        } catch (Exception e) { }
        return defaulte;
    }

    public boolean wasRunned() {
        return this.runed;
    }

    public boolean wasCanceled() {
        return this.canceled;
    }

}
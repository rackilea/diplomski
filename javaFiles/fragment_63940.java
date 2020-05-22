import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Recorder {

    private final ExecutorService executor;
    private Thread recordingThread;
    private volatile boolean stopRecording;
    private CountDownLatch finishedRecording;
    private Collection<Object> eyeData;
    private int maxCollect;
    private final AtomicBoolean started = new AtomicBoolean();
    private final AtomicBoolean stopped = new AtomicBoolean();

    public Recorder() {
        this(null);
    }

    public Recorder(ExecutorService executor) {
        this.executor = executor;
    }

    public Recorder maxCollect(int max) { maxCollect = max; return this; }

    private class RecordingRunnable implements Runnable {

        @Override public void run() {

            try {
                int collected = 0;
                while (!stopRecording) {
                    eyeData.add(EyeTracker.getData());
                    if (maxCollect > 0 && ++collected >= maxCollect) {
                        stopRecording = true;
                    }
                }
            } finally {
                finishedRecording.countDown();
            }
        }
    }

    public Recorder start() {

        if (!started.compareAndSet(false, true)) {
            throw new IllegalStateException("already started");
        }
        stopRecording = false;
        finishedRecording = new CountDownLatch(1);
        eyeData = new ArrayList<Object>();
        // the RecordingRunnable created below will see the values assigned above ('happens before relationship')
        if (executor == null) {
            recordingThread = new Thread(new RecordingRunnable());
            recordingThread.start();
        } else {
            executor.execute(new RecordingRunnable());
        }
        return this;
    }

    public Collection<Object> getData(long timeout, TimeUnit tunit) {

        if (started.get() == false) {
            throw new IllegalStateException("start first");
        }
        if (!stopped.compareAndSet(false, true)) {
            throw new IllegalStateException("data already fetched");
        }
        if (maxCollect <= 0) {
            stopRecording = true;
        }
        boolean recordingStopped = false;
        try {
            // this establishes a 'happens before relationship'
            // all updates to eyeData are now visible in this thread.
            recordingStopped = finishedRecording.await(timeout, tunit);
        } catch(InterruptedException e) { 
            throw new RuntimeException("interrupted", e);
        } finally {
            stopRecording = true;
        }
        // if recording did not stop, do not return the eyeData (could stil be modified by recording-runnable).
        if (!recordingStopped) {
            throw new RuntimeException("recording");
        }
        // only when everything is OK this recorder instance can be re-used
        started.set(false);
        stopped.set(false);
        return eyeData;
    }

    public static class EyeTracker {

        public static Object getData() {
            try { Thread.sleep(1); } catch (Exception ignored) {}
            return new Object();
        }
    }

    public static void main(String[] args) {

        System.out.println("Starting.");
        ExecutorService exe = Executors.newSingleThreadExecutor();
        try { 
            Recorder r = new Recorder(exe).maxCollect(50).start();
            int dsize = r.getData(2000, TimeUnit.MILLISECONDS).size();
            System.out.println("Collected "  + dsize);
            r.maxCollect(100).start();
            dsize = r.getData(2000, TimeUnit.MILLISECONDS).size();
            System.out.println("Collected "  + dsize);
            r.maxCollect(0).start();
            Thread.sleep(100);
            dsize = r.getData(2000, TimeUnit.MILLISECONDS).size();
            System.out.println("Collected "  + dsize);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            exe.shutdownNow();
            System.out.println("Done.");
        }
    }
}
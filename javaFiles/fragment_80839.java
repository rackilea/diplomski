public interface ProgressListener {
    void report(String step);
}

public class BackgroundTask {
    private ProgressListener listener;

    public BackgroundTask(ProgressListener listener) {
        this.listener = listener;
    }

    //...
    private void reportNewStep(String step) {
        listener.report(step);
    }
}
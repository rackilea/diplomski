public class MyActivity implements ProgressListener {
    private Notification notification;

    // ...
    @Override
    public void report(String step) {
        notification.alert(step);
    }
    // ...
    BackgroundTask backgroundTask = new BackgroundTask(this);
}
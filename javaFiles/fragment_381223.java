public class YourTask implements Runnable, Comparable<YourTask> {
    private Notification notification;

    public YourTask(Notification notification) {
        this.notification = notification;
    }
    @Override
    public void run() {
        someMethod.processNotification(notification)
    }

    @Override
    public int compareTo(B other) {
        // Here you implement the priority
        return notification.getTimestamp().compareTo(other.notification.getTimestamp());
    }
}
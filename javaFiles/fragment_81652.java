public class EventFirer extends TimerTask {
    private final MyEvent event;

    public EventFirer(MyEvent event) {
        this.event = event;
    }

    public void run() {
        event.fire();
    }
}
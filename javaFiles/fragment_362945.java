public class EventBus {
    private static EventBus instance;

    private Set<IReceivesPeriodChangedEvents> receivers;

    private EventBus() {
        this.receivers = new HashSet<IReceivesPeriodChangedEvents>();
    }

    public static EventBus getInstance() {
        if (instance == null) {
            instance = new EventBus();
        }

        return instance;
    }

    public void addReceiver(IReceivesPeriodChangedEvents receiver) {
        this.receivers.add(receiver);
    }

    public void notifyPeriodChanged() {
        for (IReceivesPeriodChangedEvents receiver : this.receivers) {
            receiver.periodChanged();
        }
    }
}
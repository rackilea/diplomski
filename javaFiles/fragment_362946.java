public class TimeslotContainer extends FlowPanel implements IReceivesPeriodChangedEvents {
    public TimeslotContainer(/* ... */) {
        // ...
        EventBus.getInstance().addReceiver(this);
    }
    // ...
}
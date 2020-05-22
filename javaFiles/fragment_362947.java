public class NavigationPanel extends FlowPanel implements IReceivesPeriodChangedEvents {
    public NavigationPanel() {
        // ...
        buildFromStore();
        EventBus.getInstance().addReceiver(this);
    }

    private void buildFromStore() {
        // Add lots of HTML elements here
    }

    @Override
    public void periodChanged() {
        clear();
        buildFromStore();
    }
}
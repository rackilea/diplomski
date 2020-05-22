public class ManuallyTimer extends Timer {

    public ManuallyTimer(int delay, ActionListener listener) {
        super(delay, listener);
    }

    public void tigger() {
        ActionEvent evt = new ActionEvent(TICK_HOUR, 0, TICK_HOUR.getActionCommand());
        fireActionPerformed(new ActionEvent(this, 0, getActionCommand(),
                        System.currentTimeMillis(),
                        0));
    }
}
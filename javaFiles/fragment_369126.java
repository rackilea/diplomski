public class JavaFollowerNotifier1 extends JFrame{

    private JLabel controlDialogLabel = new JLabel("  ");
    private JLabel settingDialogLabel = new JLabel("  ");
    private ControlDialog control;
    private SettingsDialog settings;

    public JavaFollowerNotifier1() {
        control = new ControlDialog(this, true, controlDialogLabel);
        settings = new SettingsDialog(this, true, settingDialogLabel);

....

class ControlDialog extends JDialog {
    private JLabel label;

    public ControlDialog(final Frame frame, boolean modal, final JLabel label) {
        super(frame, modal);
        this.label = label;

....

class SettingsDialog extends JDialog {
    private JLabel label;

    public SettingsDialog(final Frame frame, boolean modal, final JLabel label) {
        super(frame, modal);
        this.label = label;
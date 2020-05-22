public abstract class DialogoFocado extends JDialog implements WindowFocusListener {

    public DialogoFocado(Frame owner) {
        super(owner);
        this.addWindowFocusListener(this);
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        this.toFront();
    }
}
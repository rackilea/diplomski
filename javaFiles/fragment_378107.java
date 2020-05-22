public class CustomMenuItem extends JMenuItem {

    public CustomMenuItem(String text) {
        super(text);
    }

    public CustomMenuItem() {
        super();
    }

    protected void processMouseEvent(MouseEvent e) {
        if (isEnabled()) super.processMouseEvent(e);
    }
}
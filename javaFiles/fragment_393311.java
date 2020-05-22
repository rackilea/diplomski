public class Window2 extends JFrame {
    private final JFrame firstWindow;

    public Window2(final JFrame firstWindow) {
        if (firstWindow == null)
            throw new IllegalArgumentException("No main window specified");

        this.firstWindow = firstWindow;

        // do initial stuff for your temp window here

        this.setVisible(true);
    }


    // have to implement actual button action listener here
    private onButtonClick() {
        firstWindow.setVisible(true);
        this.dispose();
    }
}
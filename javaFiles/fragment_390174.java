public class SomeListener implements ActionListener {
    private GUI gui;
    private JTextField field;

    public SomeListener(GUI gui) {
        this.gui = gui;
        this.field = gui.getTextField();
    }
}
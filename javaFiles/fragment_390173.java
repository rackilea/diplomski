public class GUI {
    private JTextField field = new JTextField();

    public GUI() {
        // pass this instance of GUI to other class
        SomeListener listener = new SomeListener(GUI.this);
    }

    public JTextField getTextField() {
        return field;
    }
}
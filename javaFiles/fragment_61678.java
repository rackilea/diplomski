public class MyButton {
    private JButton button = new JButton();
    public MyButton() {
    }
    // probably some another constructors.

    public JComponent getComponent() {
        return button;
    }

    public void setText(String text) {
        button.setText(text);
    }
}
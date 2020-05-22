public class MyButton extends JPanel {
    private JButton button = new JButton();
    public MyButton() {
        init();
    }
    // probably some another constructors.
    private void init() {
        setLayout(new GridLayout()); // button take the entire place of the panel
        add(button);
    }

    public void setText(String text) {
        button.setText(text);
    }
}
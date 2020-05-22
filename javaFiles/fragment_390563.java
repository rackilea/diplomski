public class MyClass implements KeyListener {

    private JTextField myField;
    private JLabel myLabel;

    public MyClass() {
        myLabel = new JLabel("Enter text here");
        myField = new JTextField();
        myField.addKeyListener(this);
    }

    @Override
    public void keyPress(KeyEvent e) {
        myLabel.setText("");
    }
}
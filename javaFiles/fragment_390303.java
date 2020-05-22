public class ButtonDemo extends JPanel
implements ActionListener {
    protected JButton b1, b2, b3, b4;
    protected JLabel labelUpn;

    public ButtonDemo() {
        //...
        labelUpn = new JLabel("UPN number here on button press");
        //...
    }

    public void actionPerformed(ActionEvent e) {
        //...
        JButton clicked = (JButton) e.getSource();
        labelUpn.setText(clicked.getText());
    }
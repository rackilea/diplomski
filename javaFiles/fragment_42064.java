public class Snippet implements ActionListener, FocusListener {
public JFrame totalGUI = new JFrame();
private JPanel buttonPanel;
private JButton B9;

public Snippet() {
    createContentPane();
}

public void createContentPane() {
    buttonPanel = new JPanel(new GridBagLayout());

    B9 = new JButton("9");
    B9.addActionListener(this);
    buttonPanel.add(B9);

    JPasswordField passwordField = new JPasswordField(20);
    passwordField.setSize(120, 30);
    passwordField.addFocusListener(this);
    buttonPanel.add(passwordField);

    totalGUI.getContentPane().add(buttonPanel);
    totalGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    totalGUI.pack();
}

private JTextComponent selectedTextField;

@Override
public void actionPerformed(ActionEvent evt) {
    if (evt.getSource() == B9 && selectedTextField != null)
        selectedTextField.setText(selectedTextField.getText() + "9");
}

public static void main(String[] args) {
    new Snippet().totalGUI.setVisible(true);
}

@Override
public void focusGained(FocusEvent e) {
    if(e.getSource() instanceof JTextComponent)
        selectedTextField = (JTextComponent) e.getSource();
}

@Override
public void focusLost(FocusEvent e) {
    // when you push the button the text field will lose focus
    // selectedTextField = null;
}
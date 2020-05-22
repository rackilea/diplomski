passwordField.addFocusListener(this);

@Override
public void focusGained(FocusEvent e) {
    selectedTextField = (JTextComponent) e.getSource();
}

@Override
public void focusLost(FocusEvent e) {
    selectedTextField = null;
}
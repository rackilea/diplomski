public void actionPerformed(ActionEvent evt) {
    Object o = evt.getSource();
    if (o instanceof JButton) {
        JButton btn = (JButton) o;
        guess += btn.getText();
        if (guess.equals(secret)) {
            JOptionPane.showMessageDialog(this, "Welcome Overloard Master");
            dispose();
        } else if (guess.length() >= 3) {
            JOptionPane.showMessageDialog(this, "WRONG", "Wrong", JOptionPane.ERROR_MESSAGE);
            guess = "";
        }
    }
}
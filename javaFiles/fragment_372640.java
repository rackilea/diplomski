private void performSomeAction(JButton button) {
    if(sa1 % 2 == 0) {
        button.setEnabled(true);
        button.setBackground(Color.green);
        button.setOpaque(false);
    }
    else {
        button.setEnabled(false);
        button.setBackground(Color.red);
        button.setOpaque(true);
    }
}
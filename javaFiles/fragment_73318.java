final JButton b=..;

//method to add keybindings to a JComponent ie JButton,JPanel,JTextField etc
private void addKeyBindings(JComponent jc) {

    //not the getInputMap(..) call it could also be JComponent.WHEN_FOCUSED etc
    jc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"), "D pressed");

    jc.getActionMap().put("D pressed", new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            //do something when d is pressed
            b.doClick();
        }
    });
}
final JTextField textfield = new JTextField();
Action enterAction = new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        //do something
    }};
 String key = "ENTER";
 KeyStroke keyStroke = KeyStroke.getKeyStroke(key);
 textfield.getInputMap().put(keyStroke, key);
 textfield.getActionMap().put(key, enterAction);
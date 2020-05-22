KeyStroke enterKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
Action updateTextfieldAction = new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        JList list = (JList)evt.getSource();
        Object selectedPackage = list.getSelectedValue();
        typePackageField.setText((String)selectedPackage );
    }
};

list = new JList(new PackagesListModel());
list.getInputMap().put(enterKeyStroke, "enter");
list.getActionMap().put("enter", updateTextfieldAction);
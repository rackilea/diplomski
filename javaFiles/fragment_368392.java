textField.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(
KeyStroke.getKeyStroke(KeyEvent.VK_TAB, java.awt.event.InputEvent.SHIFT_DOWN_MASK), "BackTab");

textField.getActionMap().put("BackTab", new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
        navigateUp();
    }
});
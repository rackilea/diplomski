JPanel panel = (JPanel)frame.getContentPane();
InputMap imap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
imap.put(KeyStroke.getKeyStroke("ENTER"), "layoutAction");
ActionMap amap = panel.getActionMap();
Action leftAction = new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        doSomethingWhenEnterIsPressed();
    }
};
amap.put("layoutAction", leftAction);

...
private void doSomethingWhenEnterIsPressed() {
    // get values from field and combo and set the layout like before
}
KeyStroke ctrlj = KeyStroke.getKeyStroke('j', InputEvent.CTRL_DOWN_MASK);
Action insertEnter = new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
        textArea.append('\n');
    }
};

textArea.getInputMap().put(ctrlj, "insert enter");
textArea.getActionMap().put("insert enter", insertEnter);
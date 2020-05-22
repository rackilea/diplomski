jtf1.getInputMap().put(KeyStroke.getKeyStroke(29), "handleGS");
jtf1.getActionMap().put("handleGS", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        jtf1.setText(jtf1.getText() + "\u241d");
    }
}
getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false), "ESCAPE");
getRootPane().getActionMap().put("ESCAPE", new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
        window.setVisible(false);
    }
});
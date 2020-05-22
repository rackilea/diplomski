final JTextField field = new JTextField(20);
add(field);
JPopupMenu pop = new JPopupMenu();
pop.add(new JLabel("Hello"));
field.setComponentPopupMenu(pop);

field.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0), "happy");
field.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, KeyEvent.CTRL_DOWN_MASK), "happy");
field.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, KeyEvent.ALT_DOWN_MASK), "happy");
field.getActionMap().put("happy", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        JPopupMenu popup = field.getComponentPopupMenu();
        popup.show(field, 0, field.getHeight());
    }
});
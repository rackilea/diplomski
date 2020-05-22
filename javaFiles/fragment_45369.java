JFrame frame = new JFrame(); //e.g.
JPanel content = (JPanel)frame.getContentPane(); 
content.getInputMap().put(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER,0),"enterDown");
content.getActionMap().put("enterDown",new AbstractAction() {
    private static final long serialVersionUID = 1l;
    @Override public void actionPerformed(ActionEvent e) {
        //This action is called, as the Enter-key was pressed.
    }
});
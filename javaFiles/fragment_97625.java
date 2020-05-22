jTextField1.addKeyListener(new KeyListener() {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int pos = jTextField1.getCaretPosition();
        jTextField1.setText(jTextField1.getText().toLowerCase());
        jTextField1.setCaretPosition(pos);
    }
});
private static class MyKeyListener extends KeyAdapter {
    JLabel l;
    public MyKeyListener(JLabel label) {
        this.l = label;
    }
    public void keyPressed(KeyEvent k) {
        // --- Do some stuff here
        // --- Realize that you are done (I.E. Label is in position)
        l.removeKeyListener(this)
    }
}
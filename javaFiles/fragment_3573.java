public void run() {
    this.getParent().addKeyListener(new KeyListener() {

        public void keyPressed(KeyEvent e) {
            appendLabel(e.getKeyChar());
        }

        public void keyReleased(KeyEvent e) { }
        public void keyTyped(KeyEvent e) { }
    });
}
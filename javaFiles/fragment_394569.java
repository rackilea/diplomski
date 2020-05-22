void example () {

    JComponent component = ...;

    component.addKeyListener(new KeyAdapter() {
        @Override public void keyPressed (KeyEvent e) {
            // do stuff
        }
    });

}
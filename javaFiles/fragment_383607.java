public void keyPressed(KeyEvent e) {
    boolean wasHeld = held;
    held = true;
    System.out.println(held);
    if ( !wasHeld) {
        Thread t = new Thread(this);
        t.start();
    }
}
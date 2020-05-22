private final AtomicBoolean canShoot = new AtomicBoolean(true);

public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();

    if (key == KeyEvent.VK_SPACE) {
        if (canShoot.compareAndSet(true, false)) {
            fire();
        }
    }
    // snip
}

public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();

    if (key == KeyEvent.VK_SPACE) {
        canShoot.set(true);
    }
    // snip
}
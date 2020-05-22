public final void keyPressed(final KeyEvent e) {
    int key = e.getKeyCode();

    // Fix AutoKeyRepeat under X11
    if (keysRemove.contains(key)) {
        keysRemove.remove(Integer.valueOf(key));
    }

    if (!keysDown.contains(key)) {
        keysDown.add(key);
        keysPressed.add(key);
        lastKeys.add(key);
        if (lastKeys.size() > 16) {
            lastKeys.remove(0);
        }
    }
    e.consume();
}
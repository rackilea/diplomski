private void getInput() {
    xMove = 0;
    yMove = 0;

    KeyManager km = handler.getKeyManager();
    if (km.up) {
        yMove = -speed;
        lastPressed = true;
    }
    //...
}

private BufferedImage getCurrentAnimationFrame() {
    KeyManager km = handler.getKeyManager();
    if (km.left && lastPressed) { 
    // replaced lastPressed == handler.getKeyManager().left since km.left must be true
        return left.getCurrentFrame();
    } else if (!km.left) {
        return left_idle.getCurrentFrame();
    }
    //...
    return null;
}
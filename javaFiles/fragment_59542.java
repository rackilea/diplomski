private BufferedImage getCurrentAnimationFrame() {
    KeyManager km = handler.getKeyManager();
    if (km.left) {
        return left.getCurrentFrame();
    } else {
        return left_idle.getCurrentFrame();
    }
    //UNREACHABLE CODE!
    return null;
}
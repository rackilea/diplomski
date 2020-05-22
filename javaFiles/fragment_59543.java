DirectionEnum lastPressed = null;

private void getInput() {
xMove = 0;
yMove = 0;
KeyManager km = handler.getKeyManager();
if (km.up) {
    yMove = -speed;
    lastPressed = DirectionEnum.UP;
}
//...
}

private BufferedImage getCurrentAnimationFrame() {    
    KeyManager km = handler.getKeyManager();
    if (lastPressed == null) {
        if (km.left) {
        return left.getCurrentFrame();
        }
        //...
    } else {
        switch (lastPressed) {
        case DOWN:
            if (!km.down){
                return down_idle.getCurrentFrame();
            }
            break;
            //...
        default:
            throw new RuntimeException("Invalid direction " + lastPressed);
        }
    }
    return null;
}
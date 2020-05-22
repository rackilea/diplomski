public void moveIt(KeyEvent evt) {
 switch (evt.getKeyCode()) {
        case KeyEvent.VK_DOWN:
            myY += 5;
            break;
        case KeyEvent.VK_UP:
            myY -= 5;
            break;
        case KeyEvent.VK_LEFT:
            myX -= 5;
            break;
        case KeyEvent.VK_RIGHT:
            myX += 5;
            break;
    } 
}
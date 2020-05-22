private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {                                       
    if (evt.getKeyCode() == KeyEvent.VK_TAB) {
        System.out.println("TAB Key Hit!");
    }
    else if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
        System.out.println("BACKSPACE Key Hit!");
        evt.consume(); // Consume the BACKSPACE Key Press.
    }
}
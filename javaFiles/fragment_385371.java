public void keyPressed(KeyEvent e){
    if(e.getKeyCode() == KeyEvent.VK_ENTER){
    e.consume();
    button.doClick();
    }
}
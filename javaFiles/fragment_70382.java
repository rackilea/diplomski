private void messageTextAreaKeyPressed(java.awt.event.KeyEvent evt) { 
 if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
    sendMessage();
    evt.consume();
 }
}
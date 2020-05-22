JTextField textField = new JTextField();
textField.addKeyListener(new KeyAdapter() {
  @Override
  public void keyTyped(KeyEvent e) {
    if(e.getKeyCode() == KeyEvent.VK_ENTER){
      // will consume the event and stop it from processing normally
      e.consume();
    }        
  }
});
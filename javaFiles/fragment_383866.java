JTextField textField = new JTextField(10);
textField.addKeyListener(new KeyAdapter() {
   public void keyTyped(KeyEvent e) {
      char c = e.getKeyChar();
      if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
         e.consume();  // ignore event
      }
   }
});
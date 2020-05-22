java.awt.EventQueue.invokeLater(new Runnable() {
  public void run() {
    // dispatch the event now
    text.dispatchEvent(new KeyEvent(text, KeyEvent.KEY_TYPED, 0, 0, KeyEvent.VK_UNDEFINED, 'H'));
  }
});
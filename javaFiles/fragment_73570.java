KeyboardFocusManager.getCurrentKeyboardFocusManager()
  .addKeyEventDispatcher(new KeyEventDispatcher() {
      @Override
      public boolean dispatchKeyEvent(KeyEvent e) {
        System.out.println("Got key event!");
        return false;
      }
});
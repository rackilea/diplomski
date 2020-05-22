KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(
    new KeyEventDispatcher() {
        public boolean dispatchKeyEvent(KeyEvent e) {
            //Get the char which was pressed from the KeyEvent:
            e.getKeyChar();
            //Return 'true' if you want to discard the event.
            return false;
        }
    });
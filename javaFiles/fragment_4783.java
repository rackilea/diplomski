public void waitForSpace() {
    final CountDownLatch latch = new CountDownLatch(1);
    KeyEventDispatcher dispatcher = new KeyEventDispatcher() {
        // Anonymous class invoked from EDT
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE)
                latch.countDown();
            return false;
        }
    };
    KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(dispatcher);
    latch.await();  // current thread waits here until countDown() is called
    KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(dispatcher);
}
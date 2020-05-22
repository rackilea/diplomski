public class MyTextField extends JTextField {

    private static final long serialVersionUID = 1833734152463502703L;

    public MyTextField() {

    }

    public void waitForKey(final int key) {
        final CountDownLatch latch = new CountDownLatch(1);
        KeyEventDispatcher dispatcher = new KeyEventDispatcher() {
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == key) {
                    latch.countDown();
                }
                return false;
            }
        };
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(dispatcher);
        try {
            //current thread waits here until countDown() is called (see a few lines above)
            latch.await();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }  
        KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(dispatcher);

    }

}
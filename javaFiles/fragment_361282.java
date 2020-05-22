public class RemoveChar extends KeyAdapter {
    public static ArrayList<Character> userLineInput;
    private boolean isPressed = false;
    private int pressedKey = 0;
    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            while (isPressed)
                if (pressedKey == '\b')
                    removeLastChar();
        }
    });

    @Override
    public void keyPressed(KeyEvent e) {
        if (!isPressed) {
            pressedKey = e.getKeyCode();
            t.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (isPressed && e.getKeyCode() == pressedKey)
            isPressed = false;
    }

    public void removeLastChar() {
        userLineInput.remove(userLineInput.size() - 1);
    }
}
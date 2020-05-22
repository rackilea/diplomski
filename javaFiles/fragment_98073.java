public class MyKeyboard {
    /*
     * Remember that the index where we store the value,
     * is the index of the key. Thereby one key might have
     * an index of 400, then your array need to have at least
     * the same size, to be able to store it.
     */
    public static boolean[] keys = new boolean[100]; // 100 is the amount of keys to remember!

    public static void update() {
        while(Keyboard.next()) {
            if (Keyboard.getEventKey() < keys.length) {
                keys[Keyboard.getEventKey()] = Keyboard.getEventKeyState();
            }
        }
    }

    public static boolean isKeyDown(int key) {
        if ((key > 0) && (key < keys.length)) {
            return keys[key];
        }

        return false;
    }
}
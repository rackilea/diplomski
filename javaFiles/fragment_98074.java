public static void update() {

    for(int i = 0; i < keys.length; i++) {
        keys[i] = false;
    }
    while(Keyboard.next()) {
        keys[Keyboard.getEventKey()] = Keyboard.getEventKeyState();
    }
}
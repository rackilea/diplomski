if (Keyboard.getEventKey() == Keyboard.KEY_A) {
    if (Keyboard.getEventKeyState()) {
        movingLeft = true;
        System.out.println("A Key Pressed");
    }
    else {
        movingLeft = false;
        System.out.println("A Key Released");
    }
}
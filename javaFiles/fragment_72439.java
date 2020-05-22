public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (event.getKeyCode() == KeyEvent.KEYCODE_POWER) {
        // do what you want with the power button
        return true;
    }
    return super.onKeyDown(keyCode, event);
}
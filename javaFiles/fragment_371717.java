public boolean onKeyUp(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_MENU) {
        if (event.getAction() == KeyEvent.ACTION_UP)
        {
            //your code
            return true;
        }
    }
    return super.onKeyUp(keyCode, event);
}
@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK) {
        // your code
        return true;
    }

    return super.onKeyDown(keyCode, event);
}
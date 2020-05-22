@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK) {

        // finish activties, change parents, whatever

        return true;
    }
    return super.onKeyDown(keyCode, event);
}
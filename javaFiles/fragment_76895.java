@Override
public boolean onKeyLongPress(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) 
    {
        // to your stuff here
        return true;
    }
    return super.onKeyLongPress(keyCode, event);
}
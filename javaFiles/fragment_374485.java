private int keyCode = KeyEvent.KEYCODE_UNKNOWN;

@Override
public boolean dispatchKeyEvent(KeyEvent e) {
    if(e.getAction() == KeyEvent.ACTION_UP) {
        if (keyCode == KeyEvent.KEYCODE_E  && e.getKeyCode() == KeyEvent.KEYCODE_F) {
            Log.d("Test", "YOU PRESSED THE E KEY and then F kEY");
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            return true;
        }else {
            keyCode = e.getKeyCode();
        }
    }
    return super.dispatchKeyEvent(e);
};
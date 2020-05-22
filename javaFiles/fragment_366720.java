@Override
public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) // KeyEvent.* lists all the key codes u pressed
        {   // do something on back.
        }  
        return super.dispatchKeyEvent(event);
    }
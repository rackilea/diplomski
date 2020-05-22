b.setOnKeyListener(new View.OnKeyListener() {
    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        // your custom implementation
        if (KeyEvent.KEYCODE_ENTER == keyCode) { // match ENTER key            {
            // show the toast
            Toast.makeText(MainActivity.this, "Hello World",
                Toast.LENGTH_SHORT).show();
            return true; // indicate that we handled event, won't propagate it
        }
        return false; // when we don't handle other keys, propagate event further
    }
});
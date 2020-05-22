OnKeyListener mMenuKeyListener = new OnKeyListener() {
    @Override
    public boolean onKey(View view, int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_MENU) {
            activity.openOptionsMenu();
            return true;
        } else {
            return false;
        }
    }
};
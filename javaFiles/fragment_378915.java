@Override
public void onAttachedToWindow() {
    super.onAttachedToWindow();
    this.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD);           
}

@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
    if(keyCode == KeyEvent.KEYCODE_HOME)
    {
        Log.i("Home Button","Clicked");
    }
    if(keyCode==KeyEvent.KEYCODE_BACK)
    {
        finish();
    }
    return false;
}
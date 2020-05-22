@SuppressLint("NewApi")
@Override
public void onWindowFocusChanged(boolean hasFocus) {
    super.onWindowFocusChanged(hasFocus);
    if (currentApiVersion >= Build.VERSION_CODES.KITKAT && hasFocus) {
        getWindow().getDecorView().setSystemUiVisibility(
               View.SYSTEM_UI_FLAG_LAYOUT_STABLE
             | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
             | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
             | View.SYSTEM_UI_FLAG_FULLSCREEN
             | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
             | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
 }
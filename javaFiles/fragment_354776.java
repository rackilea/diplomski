currentApiVersion = Build.VERSION.SDK_INT;
final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        | View.SYSTEM_UI_FLAG_FULLSCREEN
        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
if (currentApiVersion >= Build.VERSION_CODES.KITKAT) {
    getWindow().getDecorView().setSystemUiVisibility(flags);
    final View decorView = getWindow().getDecorView();
    decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
          @Override
          public void onSystemUiVisibilityChange(int visibility) {
              if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                   decorView.setSystemUiVisibility(flags);
              }
          }
    });
}
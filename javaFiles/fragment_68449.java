@Override
protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState); 

    View decorView = hideSystemUI();
        decorView.setOnSystemUiVisibilityChangeListener(new 
    View.OnSystemUiVisibilityChangeListener() {
        @Override
        public void onSystemUiVisibilityChange(int visibility) {
            hideSystemUI();
        }
    });
}

private View hideSystemUI() {
    View decorView = getWindow().getDecorView();
    decorView.setSystemUiVisibility(
         View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
             | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
             | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
             | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
             | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
             | View.SYSTEM_UI_FLAG_FULLSCREEN);
    return decorview;
}
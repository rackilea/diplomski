@Override
public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);

    // Checks the orientation of the screen
    if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        //retrieving resources for the variations
        setContentView(R.layout.activity_main);

    } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
        //retrieving resources for the variations
        setContentView(R.layout.activity_main);

    }
}
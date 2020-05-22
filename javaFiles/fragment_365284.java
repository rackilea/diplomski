private int currentOrientation;

public void onCreate(Bundle sis) {
    ...
    currentOrientation = getResources().getConfiguration().orientation;
}

public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);

    if(currentOrientation != newConfig.orientation) {
        //re-set the layout into your activity
        setContentView(R.layout.my_layout);
        currentOrientation = newConfig.orientation;
    }
}
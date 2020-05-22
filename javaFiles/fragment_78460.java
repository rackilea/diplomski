public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.i("Search Activity", "onCreate() was called.");
}

@Override
public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    Log.i("Search Activity", "onConfigurationChanged was called.");
}
@Override
protected void onCreate(Bundle savedInstanceState) {
    this.application = (MyApplication) getApplication();
}

@Override
protected void onPause() {
    super.onPause();
    this.application.activityPaused();
}

@Override
protected void onResume() {
    super.onResume();
    this.application.activityResumed();
}
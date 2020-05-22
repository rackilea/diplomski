protected void onResume() {
    super.onResume();
    //[... other code...]
    MyApplicationClass app = (MyApplicationClass)getApplication();
    app.setActivityFocusIndicator(inFocus);
}
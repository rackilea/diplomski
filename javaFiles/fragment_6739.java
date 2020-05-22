@Override
protected void onResume() {
  super.onResume();
  MyApplication.activityResumed();
}

@Override
protected void onPause() {
  super.onPause();
  MyApplication.activityPaused();
}
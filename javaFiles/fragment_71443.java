@Override
protected void onStop() {
    super.onStop();

    SharedPreferences sPrefs = getSharedPreferences("sharedPreferences", MODE_PRIVATE);
    SharedPreferences.Editor editor = sPrefs.edit();
    editor.putLong("timeleft", timesLeft);
    editor.putLong("sysstoptime", System.currentTimeMillis());
    editor.apply();
}
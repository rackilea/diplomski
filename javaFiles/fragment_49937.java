public void onActivityResult(int requestCode, int resultCode, Intent data) {

    Toast.makeText(ONTTMainActivity .this, "Toast Reached", Toast.LENGTH_LONG).show();

    if (resultCode == RESULT_OK) {
            SharedPreferences settings = getSharedPreferences("ONTT_prefs", 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("firstRun", false);
            editor.commit();
    }
}
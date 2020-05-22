InstantAppIntentData intentData = InstantApps
    .getLauncher(MainActivity.this)
    .getInstantAppIntentData("https://vimeo.com/148943792", null);
int matchResult = intentData.getMatchResult();
if (matchResult == RESULT_LAUNCH_OK) {
  Log.i(TAG, "Launching instant: " + intentData.getPackageName());
  startActivity(intentData.getIntent());
} else {
  Log.i(TAG, "Match result: " + matchResult);
}

InstantApps
  .getLauncher(MainActivity.this)
  .getInstantAppLaunchData("https://vimeo.com/148943792")
  .addOnCompleteListener(task -> {
    if (task.isSuccessful()) {
      LaunchData data = task.getResult();
      Intent launchIntent = data.getIntent();
      if (launchIntent != null) {
        Log.i(TAG, "App label: " + data.getApplicationLabel());
        Log.i(TAG, "Package: " + data.getPackageName());
        Log.i(TAG, "Icon width: " + data.getApplicationIcon().getWidth());
        startActivity(launchIntent);
      } else {
        Log.i(TAG, "No instant app found");
      }
    } else {
      Log.i(TAG, "Error: " + task.getException());
    }
  });
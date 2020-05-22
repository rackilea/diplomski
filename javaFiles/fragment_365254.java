private void processIntent(final Intent intent) {
  if ((intent.getFlags() & Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY) != 0) {
//  Log.v(TAG, "Ignoring intent; already treated this intent.");
    return;
  }
  intent.addFlags(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY);
  // new intent; process it
  ...
}
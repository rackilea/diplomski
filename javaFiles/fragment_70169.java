@Override
public void onDestroy() {
  super.onDestroy();
  Intent broadcastIntent = new Intent("com.company.AppName.RestartLocationSyncService");
  broadcastIntent.setComponent(new ComponentName("com.company.AppName", "com.company.AppName.LocationSyncServiceRestarterBroadcastReceiver"));
  sendBroadcast(broadcastIntent);
}
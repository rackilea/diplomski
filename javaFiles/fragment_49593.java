broadcastReceiver = new EventReceiver();
IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
filter.addAction(Intent.ACTION_SCREEN_OFF);
filter.addAction("android.provider.Telephony.SMS_RECEIVED");
filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY-1);
registerReceiver(broadcastReceiver, filter);
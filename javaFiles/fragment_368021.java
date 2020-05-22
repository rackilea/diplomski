Intent mStartActivity = new Intent(MainActivity.this, MainActivity.class);
int mPendingIntentId = 123456;
PendingIntent mPendingIntent = PendingIntent.getActivity(MainActivity.this, mPendingIntentId, mStartActivity, PendingIntent.FLAG_CANCEL_CURRENT);
AlarmManager mgr = (AlarmManager)MainActivity.this.getSystemService(Context.ALARM_SERVICE);
mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent);
System.exit(0);
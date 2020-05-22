AlarmManager am =
  (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
Intent intent1 = new Intent(context, myReceiver.class);
PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, 0);
Intent intent2 = new Intent(context, myActivity.class);
PendingIntent pi2 = PendingIntent.getActivity(context, 0, i2, 0);

AlarmManager.AlarmClockInfo ac=
  new AlarmManager.AlarmClockInfo(System.currentTimeMillis() + DELAY,
    pi2);

am.setAlarmClock(ac, pi);
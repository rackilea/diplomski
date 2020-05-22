AlarmManager alarmManager = (AlarmManager) Context.getSystemService(Context.ALARM_SERVICE);

Intent gcmKeepAliveIntent = new Intent("com.gmail.npnster.ourlatitude.gcmKeepAlive");

PendingIntent gcmKeepAlivePendingIntent = PendingIntent.getBroadcast(mContext, 0, gcmKeepAliveIntent, PendingIntent.FLAG_CANCEL_CURRENT);

alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, 1000, 4*60*1000, gcmKeepAlivePendingIntent);
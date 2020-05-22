AlarmManager alarmMgr = (AlarmManager) this
                    .getSystemService(Context.ALARM_SERVICE);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0,
                    new Intent(this, AlarmReceiver_update.class),
                    PendingIntent.FLAG_CANCEL_CURRENT);
            alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    0, yourTimeInterval, pendingIntent);
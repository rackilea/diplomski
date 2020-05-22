Intent intent = new Intent(MainActivity.this, AlarmReceiver.class);
            intent.putExtra("notificationId", notificationId);
            intent.putExtra("text", text);
            intent.putExtra("alarmStartTime", alarmStartTime);               
            PendingIntent alarmIntent = PendingIntent.getBroadcast(MainActivity.this, notificationId, intent, PendingIntent.FLAG_CANCEL_CURRENT);
            AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);
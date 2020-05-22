// Init the Alarm Manager.
AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE); 

// Setting the PendingIntent to be fired when alarm triggers.
Intent serviceIntent = new Intent(context.getApplicationContext(), YourService.class);
PendingIntent pendingServiceIntent = PendingIntent.getService(context, 0, serviceIntent, 0);

// Set the alarm for the next seconds.  
alarmManager.setExactAndAllowWhileIdle(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + seconds * 1000, pendingServiceIntent);
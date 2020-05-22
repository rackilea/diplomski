private static Intent alarmIntent = null;
private static PendingIntent pendingIntent = null;
private static AlarmManager alarmManager = null;

    // OnCreate()
    alarmIntent = new Intent ( null, AlarmReceiver.class );
    pendingIntent = PendingIntent.getBroadcast( this.getApplicationContext(), 234324243, alarmIntent, 0 );
alarmManager = ( AlarmManager ) getSystemService( ALARM_SERVICE );
    alarmManager.setRepeating( AlarmManager.RTC_WAKEUP, ( uploadInterval * 1000 ),( uploadInterval * 1000 ), pendingIntent );
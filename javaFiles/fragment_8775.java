public void OffAlarm(View arg0){
    Intent myIntent = new Intent(Alarm.this, MyAlarmService.class);
    pendingIntent = PendingIntent.getService(Alarm.this, 0, myIntent, 0);
    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
    alarmManager.cancel(pendingIntent);

    // Stops an existing running service

    stopService(myIntent);

    // Tell the user about what we did.
    Toast.makeText(Alarm.this, "Cancel!", Toast.LENGTH_LONG).show();
}
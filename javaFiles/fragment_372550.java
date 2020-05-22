private void cancelAlarm(int alarmId){
    Intent i = new Intent(getBaseContext(), AlarmReceiver.class);
    PendingIntent sender = PendingIntent.getBroadcast(MainActivity.this, alarmId, i, PendingIntent.FLAG_UPDATE_CURRENT);

    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
    alarmManager.cancel(sender);
    sender.cancel();
}
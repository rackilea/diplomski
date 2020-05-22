@Override
public void onTaskRemoved(Intent rootIntent){
    Intent restartServiceTask = new Intent(getApplicationContext(),this.getClass());
    restartServiceTask.setPackage(getPackageName());    
    PendingIntent restartPendingIntent =PendingIntent.getService(getApplicationContext(), 1,restartServiceTask, PendingIntent.FLAG_ONE_SHOT);
    AlarmManager myAlarmService = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
    myAlarmService.set(
            AlarmManager.ELAPSED_REALTIME,
            SystemClock.elapsedRealtime() + 1000,
            restartPendingIntent);

    super.onTaskRemoved(rootIntent);
}
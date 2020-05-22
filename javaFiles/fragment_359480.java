PendingIntent pi = null;

private void startMonitor() {
    AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    Intent i = new Intent(this, OnTickReceiver.class);
    pi = PendingIntent.getBroadcast(this, 0, i, 0);

    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis() + 120 * 1000, 120 * 1000, pi);
}

private void stopMonitor() {
    AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    alarmManager.cancel(pi);
}
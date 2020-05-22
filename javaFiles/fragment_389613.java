public void setScheduling() {
    Date now = new Date();

    // Set the time to download to 18:00
    Calendar cal = Calendar.getInstance();
    cal.setTime(now);
    cal.set(Calendar.HOUR_OF_DAY, 18);
    cal.set(Calendar.MINUTE, 0);

    AlarmManager mgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    Intent i = new Intent(context, StartDownloadReceiver.class);
    PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, 0);

    mgr.cancel(pi);

    // 1 * 24 * 60 * 60 * 1000 = repeat this every day
    mgr.setRepeating(AlarmManager.RTC, cal.getTimeInMillis(), 1 * 24 * 60 * 60 * 1000, pi);
}
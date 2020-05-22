private void setAlarm() {
 AlarmManager alarmMgr = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
 Intent intent = new Intent(YourActivity.this, AlarmReceiver.class);
 PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
 Calendar cal = Calendar.getInstance();
 cal.set(Calendar.HOUR_OF_DAY, 23);//set the hour which you want
 cal.set(Calendar.MINUTE, 56);// set the minute
 cal.set(Calendar.SECOND, 0);// set seconds
 alarmMgr.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
}
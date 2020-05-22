Calendar calendar = Calendar.getInstance();
// calendar.setTimeInMillis(System.currentTimeMillis()); // YOU DON'T NEED THIS LINE
calendar.set(Calendar.HOUR_OF_DAY, 5);
calendar.set(Calendar.MINUTE, 0);
calendar.set(Calendar.SECOND, 0);

Calendar current = Calendar.getInstance();

int curTime = current.getTimeInMillis();
int alarmTime = calendar.getTimeInMillis();

if (alarmTime >= curTime){
   manager.setRepeating(AlarmManager.RTC_WAKEUP,
        alarmTime, AlarmManager.INTERVAL_DAY, // for repeating
        // in every 24
        // hours
        pendingIntent);
}else{
   calendar.add(Calendar.DAY_OF_MONTH, 1);
   int alarmTime = calendar.getTimeInMillis();
   manager.setRepeating(AlarmManager.RTC_WAKEUP,
        alarmTime, AlarmManager.INTERVAL_DAY, // for repeating
        // in every 24
        // hours
        pendingIntent);
}
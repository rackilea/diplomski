AlarmManager alarm = (AlarmMAnager) Context.getSystemService(Context.ALARM_SERVICE);
Calendar timeOff = Calendar.getInstance();
int days = Calendar.SUNDAY + (7 - timeOff.get(Calendar.DAY_OF_WEEK)); // how many days until Sunday
timeOff.add(Calendar.DATE, days);
timeOff.set(Calendar.HOUR, 12);
timeOff.set(Calendar.MINUTE, 0);
timeOff.set(Calendar.SECOND, 0);

alarm.set(AlarmManager.RTC_WAKEUP, timeOff.getTimeInMillis(), yourOperation);
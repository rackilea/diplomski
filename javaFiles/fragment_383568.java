Calendar calendar = Calendar.getInstance();
calendar.set(2015, Calendar.NOVEMBER, 13, 13, 0, 0);
int offset = calendar.get(Calendar.ZONE_OFFSET) + calendar.get(Calendar.DST_OFFSET);
long utcTimeInMillis = calendar.getTimeInMillis() + offset;

Calendar utcCalendar = Calendar.getInstance(Locale.ENGLISH);
utcCalendar.setTimeInMillis(utcTimeInMillis);

Log.d(TAG, "Time: " + calendar.getTime());
Log.d(TAG, "TimeInMillis: " + calendar.getTimeInMillis());
Log.d(TAG, "DisplayName: " + calendar.getTimeZone().getDisplayName());
Log.d(TAG, "Offset: " + offset);
Log.d(TAG, "UTC Time: " + utcCalendar.getTime());
Log.d(TAG, "UTC TimeInMillis: " + utcTimeInMillis);
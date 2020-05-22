Calendar cal = Calendar.getInstance(); // returns current time in user's default TimeZone
cal.set(Calendar.MILLISECOND, 0);
cal.set(Calendar.SECOND, 0);
cal.set(Calendar.MINUTE, 0);
cal.set(Calendar.HOUR_OF_DAY, 19);
long time = cal.getTime().getTime();
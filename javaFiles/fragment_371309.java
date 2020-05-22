//1. parse your input as a date object.
SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
Date startDate = format.parse("01:30:00");

//2. feed it to a Calendar Object
Calendar calendar = Calendar.getInstance();
calendar.setTime(startDate);

//3. get the hour, minute, second variable
int hour = calendar.get(Calendar.HOUR_OF_DAY);
int minute = calendar.get(Calendar.MINUTE);
int second = calendar.get(Calendar.SECOND);

//4. apply to your Chronometer class.
mChronometer.setBase(SystemClock.elapsedRealtime() - (hour * 60000 * 60 + minute * 60000 + second * 1000)))
String smsBody=getIntent().getExtras().getString("smsBody");
String msg = smsBody.toString();
String[] time = msg.split(":");
int Hours = Integer.parseInt(time[0]);
int Minutes = Integer.parseInt(time[1]);

alarmTimePicker.setCurrentHour(Hours);
alarmTimePicker.setCurrentMinute(Minutes);
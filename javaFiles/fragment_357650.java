SimpleDateFormat yourDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
Date date = null;
 try { 
      String date_time = "17-11-2017 15:10";
      date = yourDateFormat.parse(date_time);

 } catch (ParseException e) {
      Log.e(TAG, "Parsing date time failed", e);
 }
 Locale locale = new Locale("en","US")
 Calendar calendar = Calendar.getInstance(locale);
 calendar.setTime(date);

 Calendar current = Calendar.getInstance();
 if (calendar.compareTo(current) <= 0) {

    Toast.makeText(getApplicationContext(), "Invalid Date/Time", Toast.LENGTH_LONG).show();
 } else {
      AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
      Intent myIntent = new Intent(RemainderActivity.this, NotificationReceiver.class);             
      PendingIntent displayIntent = PendingIntent.getBroadcast(getBaseContext(), 0, myIntent, 0);
      alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), displayIntent);

}
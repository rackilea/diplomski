Calendar calendar =
   Calendar.getInstance(
       TimeZone.getTimeZone("America/Chicago"),
       Locale.getDefault()
   );

calendar.set( Calendar.HOUR_OF_DAY, 0 );
calendar.set( Calendar.MINUTE, 15 );
calendar.set( Calendar.SECOND, 0 );
calendar.set( Calendar.MILLISECOND, 0 );

calendar.add( Calendar.DAY_OF_MONTH, 1 );
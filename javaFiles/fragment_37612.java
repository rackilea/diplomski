Calendar mCalendar = new GregorianCalendar();
 TimeZone mTimeZone = mCalendar.getTimeZone();
 int mGMTOffset = mTimeZone.getRawOffset();

 double sZone = (double) (TimeUnit.MINUTES.convert(mGMTOffset,TimeUnit.MILLISECONDS));
string timeDiff = sZone / 60;
protected String getUTCMilliseconds(Calendar cal) {
    Calendar utcCal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    utcCal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
    utcCal.set(Calendar.DAY_OF_YEAR, cal.get(Calendar.DAY_OF_YEAR)); 
    utcCal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY));
    utcCal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE));
    utcCal.set(Calendar.SECOND, cal.get(Calendar.SECOND));
    utcCal.set(Calendar.MILLISECOND, cal.get(Calendar.MILLISECOND));
    return String.valueOf(utcCal.getTimeInMillis());
}
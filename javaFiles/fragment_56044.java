public static Calendar getNearestDateFromDayString(final String dayOfWeekStr,
        final Calendar startingDay) throws ParseException {
    final DateFormat formatter = new SimpleDateFormat("EEE");
    final java.util.Date date = (Date) formatter.parse(dayOfWeekStr);
    final Calendar result = Calendar.getInstance();
    result.setTime(date);
    result.set(Calendar.YEAR, startingDay.get(Calendar.YEAR));
    result.set(Calendar.MONTH, startingDay.get(Calendar.MONTH));
    result.set(Calendar.HOUR, startingDay.get(Calendar.HOUR));
    result.set(Calendar.MINUTE, startingDay.get(Calendar.MINUTE));
    result.set(Calendar.SECOND, 0);
    java.util.Date today = new java.util.Date();
    while (result.getTimeInMillis() <= today.getTime()) { 
        result.add(Calendar.DATE, 7);
    }   // while
    return result;
} // getNearestDateFromDayString
public static Date copyTimeOnly(Date toDate, Date fromDate) {
    Calendar toCal = new GregorianCalendar();
    toCal.setTime(toDate);

    Calendar fromCal = new GregorianCalendar();
    fromCal.setTime(fromDate);

    // Copy time only
    toCal.set(Calendar.HOUR_OF_DAY, fromCal.get(Calendar.HOUR_OF_DAY));
    toCal.set(Calendar.MINUTE, fromCal.get(Calendar.MINUTE));
    toCal.set(Calendar.SECOND, fromCal.get(Calendar.SECOND));
    toCal.set(Calendar.MILLISECOND, fromCal.get(Calendar.MILLISECOND));

    return toCal.getTime();
}
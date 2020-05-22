private static int oldJDK() { // only JDK-definition
    GregorianCalendar gcal = new GregorianCalendar();
    gcal.setMinimalDaysInFirstWeek(4);
    gcal.setFirstDayOfWeek(Calendar.MONDAY);
    return gcal.get(Calendar.WEEK_OF_MONTH);
}
private static Date newDate(int year, int month, int day) {
    Calendar cal = Calendar.getInstance();
    cal.set(year, month, day);
    // if you want the last milli-second of the day for an upper bound
    cal.add(Calendar.DAY_OF_MONTH, 1);
    cal.add(Calendar.MILLISECOND, -1);
    return cal.getTime();
}

private final static Date programCutoffDate2015 = newDate(2015, 12, 31);
protected static Calendar getCalendarForMillis(long millis) {
    Calender ret = Calendar.getInstance();
    ret.setTimeInMillis(millis);
    return ret;
}

public SimpleDate(long millis) {
    this(getCalendarForMillis(millis));
}
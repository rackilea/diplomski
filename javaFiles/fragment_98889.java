public static Calendar convertToGmt(Calendar cal) {

    Date date = cal.getTime();
    TimeZone tz = cal.getTimeZone();

    log.debug("input calendar has date [" + date + "]");

    //Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT 
    long msFromEpochGmt = date.getTime();

    //gives you the current offset in ms from GMT at the current date
    int offsetFromUTC = tz.getOffset(msFromEpochGmt);
    log.debug("offset is " + offsetFromUTC);

    //create a new calendar in GMT timezone, set to this date and add the offset
    Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    gmtCal.setTime(date);
    gmtCal.add(Calendar.MILLISECOND, offsetFromUTC);

    log.debug("Created GMT cal with date [" + gmtCal.getTime() + "]");

    return gmtCal;
}
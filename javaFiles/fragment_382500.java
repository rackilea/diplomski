final static int DAY_MILLIS = 24 * 60 * 60 * 1000;
static String hols[] = new String[] { "01/01", "05/01", "06/01", "10/20", "12/12", "12/25", "12/26" };

public static long addWorkingTime(long timestamp, long milliseconds)
{
    // Get a calendar from a timestamp.
    Calendar cal = new GregorianCalendar();
    cal.setTimeInMillis(timestamp);
    while (isHoliday(cal)) cal.add(Calendar.DATE, 1);

    // Count off the days in milliseconds.
    int days = (int)(milliseconds / DAY_MILLIS);
    for (int i = 0; i < days; i++) {
        cal.add(Calendar.DATE, 1);
        while (isHoliday(cal)) cal.add(Calendar.DATE, 1);
    }

    // Apply the leftover from milliseconds if there is any.
    milliseconds = milliseconds - days * DAY_MILLIS;
    cal.add(Calendar.MILLISECOND, milliseconds);
    while (isHoliday(cal)) cal.add(Calendar.DATE, 1);

    // Return a timestamp from a calendar.
    return cal.getTimeInMillis();
}

static boolean isHoliday(Calendar cal)
{
    int dow = cal.get(Calendar.DAY_OF_WEEK);
    if (dow == Calendar.SATURDAY || dow == Calendar.SUNDAY) return true;
    String mmdd = new SimpleDateFormat("MM/dd").format(cal.getTime());
    return Arrays.binarySearch(hols, mmdd) >= 0;
}
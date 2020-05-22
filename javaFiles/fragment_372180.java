// Note: day-of-week runs from Sunday (1) to Saturday (7).
// Entry 0 here is not used. We could do this without an array lookup
// if desired, but it's whatever code you think is clearest.
private static final int[] EXTRA_DAYS = { 0, 6, 0, 1, 2, 3, 4, 5 };

// Note: 0-based month as per the rest of java.util.Calendar
public static int getWeekCount(int year, int month) {
    Calendar calendar = new GregorianCalendar(year, month, 1);
    int dayOfWeekOfStartOfMonth = calendar.get(Calendar.DAY_OF_WEEK);
    int extraDays = EXTRA_DAYS[dayOfWeekOfStartOfMonth];
    int regularDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    int effectiveDaysInMonth = regularDaysInMonth + extraDays;
    return effectiveDaysInMonth / 7;
}
public static Calendar getClosestFutureWeekday(int dayOfWeek, int hour, int minute, int second)
{
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);
    calendar.set(Calendar.HOUR_OF_DAY, hour);
    calendar.set(Calendar.MINUTE, minute);
    calendar.set(Calendar.SECOND, second);
    if (calendar.before(Calendar.getInstance()))
    {
        calendar.add(Calendar.DAY_OF_MONTH, 7);
    }
    return calendar;
}
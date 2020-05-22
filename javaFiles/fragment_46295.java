DateTime weekStart = getUSFirstDayOfWeek(now);
DateTime weekEnd = now.withDayOfWeek(DateTimeConstants.SATURDAY).plusDays( 0 );

public static DateTime getUSFirstDayOfWeek(DateTime dateTime) {
    return dateTime.withDayOfWeek(DateTimeConstants.MONDAY).minusDays(1);
}
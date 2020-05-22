private static List<Interval> getWeeks(final DateTime start, final DateTime finish)
{
    final int weekLeaps = Weeks.weeksBetween(start, finish).getWeeks();
    if (weekLeaps == 0) {
        return ImmutableList.of(new Interval(start, finish));
    } else {
        // We hop sundays at least once
        final ImmutableList.Builder<Interval> resBuild = ImmutableList.<Interval> builder();

        // First week
        DateTime wStart = start;
        DateTime wEnd = rollToWeekEnd(start);
        resBuild.add(new Interval(wStart, wEnd));

        // Other weeks
        for (int i = 0; i < weekLeaps; i++) {
            wStart = wEnd.plusSeconds(1);
            DateTime actWeekEnd = rollToWeekEnd(wStart);
            wEnd = actWeekEnd.isBefore(finish) ? actWeekEnd : finish;
            resBuild.add(new Interval(wStart, wEnd));
        }

        return resBuild.build();
    }
}

private static DateTime rollToWeekEnd(final DateTime from)
{
    return from.withDayOfWeek(DateTimeConstants.SUNDAY)
        .withHourOfDay(23)
        .withMinuteOfHour(59)
        .withSecondOfMinute(59)
        .withMillisOfSecond(0);
}
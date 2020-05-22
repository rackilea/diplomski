@Test
public void parseInfiniteTimestampIntervals() throws ParseException {
    IsoRecurrence<TimestampInterval> intervals =
        IsoRecurrence.parseTimestampIntervals("R/2019-01-01T00:00:00/P1D");

    PlainDate start = PlainDate.of(2019, 6, 11);
    PlainDate end = PlainDate.of(2019, 6, 15);

    for (TimestampInterval interval : intervals) {
        PlainDate current = interval.getStartAsTimestamp().getCalendarDate();
        if (current.isAfterOrEqual(start)) {
            if (current.isBeforeOrEqual(end)) {
                System.out.println(interval); // or do your own stuff with the current interval
            } else {
                break; // end of infinite loop
            }
        }
    }
}
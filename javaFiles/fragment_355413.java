public static void main(String[] args) throws Throwable {

    System.out.println(getWeekOfMonth(false)); // CLDR/ISO-spec
    // 1 for today=2016-02-05
    // 2 for today=2016-02-12
    // 4 for today=2016-02-28
    // 1 for today=2016-02-29

    System.out.println(getWeekOfMonth(true)); // JDK-behaviour
    // 1 for today=2016-02-05
    // 2 for today=2016-02-12
    // 4 for today=2016-02-28
    // 5 for today=2016-02-29

}

private static int getWeekOfMonth(boolean bounded) {
    int weekOfMonth;
    LocalDate today = LocalDate.now();

    LocalDate first = today.dayOfMonth().withMinimumValue();
    int dowFirst = first.getDayOfWeek();

    if (dowFirst <= DateTimeConstants.THURSDAY) {
        // we are in week 1 and go to Monday as start of week
        first = first.minusDays(dowFirst - DateTimeConstants.MONDAY);

        // first try: we determine the week of current month
        weekOfMonth = Days.daysBetween(first, today).getDays() / 7 + 1;

        if (!bounded) {
            // edge case: are we in first week of next month?
            LocalDate next = first.plusMonths(1);
            int dowNext = next.getDayOfWeek();

            if (dowNext <= DateTimeConstants.THURSDAY) {
                next = next.minusDays(dowNext - DateTimeConstants.MONDAY);
                if (!next.isAfter(today)) {
                    weekOfMonth = 1;
                }
            }
        }
    } else if (bounded) {
        weekOfMonth = 0;
    } else {
        // we are in last week of previous month so let's check the start of previous month
        LocalDate previous = first.minusMonths(1);
        int dowPrevious = previous.getDayOfWeek();

        if (dowPrevious <= DateTimeConstants.THURSDAY) {
            previous = previous.minusDays(dowPrevious - DateTimeConstants.MONDAY);
        } else {
            previous = previous.plusDays(DateTimeConstants.MONDAY - dowPrevious + 7);
        }

        weekOfMonth = Days.daysBetween(previous, today).getDays() / 7 + 1;
    }

    return weekOfMonth;
}
public static List<LocalDate> getPostDates(LocalDate endDate) {
    DayOfWeek dow = endDate.getDayOfWeek();
    if (! dow.equals(DayOfWeek.SUNDAY)) {
        throw new IllegalArgumentException("End date must be Sunday, was " + dow);
    }

    List<LocalDate> result = new ArrayList<>(5);
    for (int week = 1; week <= 4; week++) {
        LocalDate lastDayOfWeek = endDate.minusWeeks(week - 1);
        result.add(lastDayOfWeek);
        // If the week crosses a month boundary, also add last day of month
        int dom = lastDayOfWeek.getDayOfMonth();
        if (dom < 7) {
            result.add(lastDayOfWeek.minusDays(dom));
        }
    }

    return result;
}
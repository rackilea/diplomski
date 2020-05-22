public static void numberOfWeeks(LocalDateTime startDateTime, LocalDateTime endDateTime) {
    if (startDateTime.isAfter(endDateTime)) {
        throw new IllegalArgumentException("End date must not be before start date");
    }

    LocalDate endDate = endDateTime.toLocalDate();
    List<String> numberWeeks = new ArrayList<>();
    LocalDate currentDate = startDateTime.toLocalDate();
    while (currentDate.isBefore(endDate)) {
        numberWeeks.add(formatWeek(currentDate));
        currentDate = currentDate.plusWeeks(1);
    }
    // Now currentDate is on or after endDate, but are they in the same week?
    if (currentDate.get(WeekFields.SUNDAY_START.weekOfWeekBasedYear()) 
            == endDate.get(WeekFields.SUNDAY_START.weekOfWeekBasedYear())) {
        numberWeeks.add(formatWeek(currentDate));
    }

    System.out.println(numberWeeks);
}

public static String formatWeek(LocalDate currentDate) {
    return String.format("%d-W%d", 
            currentDate.get(WeekFields.SUNDAY_START.weekBasedYear()), 
            currentDate.get(WeekFields.SUNDAY_START.weekOfWeekBasedYear()));
}
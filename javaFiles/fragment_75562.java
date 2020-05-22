public static List<String> generateQuarterlySequence(LocalDate startDate, LocalDate endDate) {
    // first truncate startDate to first day of quarter
    int startMonth = startDate.getMonthValue();
    startMonth-= (startMonth - 1) % 3;
    startDate = startDate.withMonth(startMonth).withDayOfMonth(1);

    DateTimeFormatter quarterFormatter 
            = DateTimeFormatter.ofPattern("uuuuQQQ", Locale.ENGLISH);
    List<String> quarterSequence = new ArrayList<>();

    // iterate thorough quarters
    LocalDate currentQuarterStart = startDate;
    while (! currentQuarterStart.isAfter(endDate)) {
        quarterSequence.add(currentQuarterStart.format(quarterFormatter));
        currentQuarterStart = currentQuarterStart.plusMonths(3);
    }
    return quarterSequence;
}
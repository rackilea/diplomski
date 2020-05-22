// set your own print format here
private static final DateTimeFormatter DF=DateTimeFormat.forPattern("dd/MM/yyyy");

    private List<String> createMonthLabels(LocalDate month) {
    // add labels
    List<String> daysInMonthLabels = new ArrayList<String>();
    LocalDate firstDay = month.withDayOfMonth(1);
    LocalDate nextMonthFirstDay = firstDay.plusMonths(1);
    while (firstDay.isBefore(nextMonthFirstDay)) {
        daysInMonthLabels.add(DF.print(firstDay));
        firstDay = firstDay.plusDays(1);
    }

    return daysInMonthLabels;
}
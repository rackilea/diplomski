public LocalDate lastDayFromDateQuarter(String date) {
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
    LocalDate ld = LocalDate.parse(date, formatter);
    int quarter = ld.get(IsoFields.QUARTER_OF_YEAR); // Get the Quarter, 1, 2, 3, 4
    // Then create a new date with new quarter * 3 and last day of month
    return ld.withMonth(quarter * 3).with(TemporalAdjusters.lastDayOfMonth());
}
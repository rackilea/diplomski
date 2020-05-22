public static LocalDate lastDayFromDateQuarter(String date) {
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
    LocalDate ld = LocalDate.parse(date, formatter);
    int quarter = ld.get(IsoFields.QUARTER_OF_YEAR);
    return ld.withMonth(quarter * 3)
            .plusMonths(3)
            .with(TemporalAdjusters.lastDayOfMonth());
}
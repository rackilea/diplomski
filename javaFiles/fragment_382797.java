DateTimeFormatter dtf = new DateTimeFormatterBuilder()
        .appendValue(ChronoField.YEAR, 4)
        .appendPattern("[['-']MM[['-']dd[['T']HH[[':']mm[[':']ss['.'SSS]]]]]]")
        .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
        .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
        .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
        .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
        .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
        .parseDefaulting(ChronoField.NANO_OF_SECOND, 0)
        .toFormatter();

String[] s = {
        "2018",
        "2018-10",
        "2018-10-15",
        "2018-10-15T12:00",
        "2018-10-15T12:00:30",
        "2018-10-15T12:00:30.123",
        "20181015",
        "201810151200",
        "20181015120030",
        "20181015120030.123",
        "20181015T12:00:30.123"
};
for (String line : s) {
  System.out.println(LocalDateTime.parse(line, dtf));
}
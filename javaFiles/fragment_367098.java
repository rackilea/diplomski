DateTimeFormatter dtf =
    new DateTimeFormatterBuilder()
    .appendValue(ChronoField.YEAR, 4)
    .appendValue(ChronoField.ALIGNED_WEEK_OF_YEAR, 2)
    .parseDefaulting(WeekFields.ISO.dayOfWeek(), 1)
    .toFormatter();
System.out.println(LocalDate.parse("201501", dtf)); // 2015-01-05 (wrong)
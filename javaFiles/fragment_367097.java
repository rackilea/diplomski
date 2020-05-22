DateTimeFormatter formatter =
    new DateTimeFormatterBuilder()
    .appendValue(WeekFields.ISO.weekBasedYear(), 4)
    .appendValue(WeekFields.ISO.weekOfWeekBasedYear(), 2)
    .parseDefaulting(ChronoField.DAY_OF_WEEK, 1)
    .toFormatter();
LocalDate startDate = LocalDate.parse("201501", formatter);
System.out.println(startDate); // 2014-12-29
private static final DateTimeFormatter FLEXIBLE_FORMATTER;

static {
    DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
    builder.appendPattern("MM/dd");
    builder.parseDefaulting(ChronoField.YEAR_OF_ERA, 1970);
    builder.parseDefaulting(ChronoField.MONTH_OF_YEAR, 1);
    builder.parseDefaulting(ChronoField.DAY_OF_MONTH, 1);
    builder.parseDefaulting(ChronoField.HOUR_OF_DAY, 0);
    builder.parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0);
    builder.parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0);
    FLEXIBLE_FORMATTER = builder.toFormatter();
}
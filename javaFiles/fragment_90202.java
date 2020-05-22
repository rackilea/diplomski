private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
    .appendValue(ChronoField.YEAR_OF_ERA, 4, 4, SignStyle.NEVER)
    .appendLiteral('-')
    .appendValue(ChronoField.MONTH_OF_YEAR, 2, 2, SignStyle.NEVER)
    .appendLiteral('-')
    .appendValue(ChronoField.DAY_OF_MONTH, 2, 2, SignStyle.NEVER)
    .optionalStart()
    .appendLiteral(' ')
    .appendValue(ChronoField.HOUR_OF_DAY, 2)
    .appendLiteral(':')
    .appendValue(ChronoField.MINUTE_OF_HOUR, 2)
    .appendLiteral(':')
    .appendValue(ChronoField.SECOND_OF_MINUTE, 2)
    .optionalEnd()
    .parseDefaulting(ChronoField.HOUR_OF_DAY, 23)
    .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 59)
    .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 59)
    .toFormatter();

LocalDateTime.parse("2000-01-01 01:02:03", DATE_TIME_FORMATTER) // 2000-01-01T01:02:03
LocalDateTime.parse("2000-01-01", DATE_TIME_FORMATTER) // 2000-01-01T23:59:59
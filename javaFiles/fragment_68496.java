DateTimeFormatter dtf = new DateTimeFormatterBuilder()
    .appendDayOfMonth(2)
    .appendLiteral('-')
    .appendMonthOfYearShortText()
    .appendLiteral('-')
    .appendTwoDigitYear(2050)
    .toFormatter().withLocale(Locale.US);
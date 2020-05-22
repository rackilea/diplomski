DateTimeFormatter formatter = 
        new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4)
                                      .appendValue(ChronoField.MONTH_OF_YEAR, 2)
                                      .appendValue(ChronoField.DAY_OF_MONTH, 2)
                                      .appendValue(ChronoField.HOUR_OF_DAY, 2)
                                      .appendValue(ChronoField.MINUTE_OF_HOUR, 2)
                                      .appendValue(ChronoField.SECOND_OF_MINUTE, 2)
                                      .appendLiteral("000000")
                                      .toFormatter();
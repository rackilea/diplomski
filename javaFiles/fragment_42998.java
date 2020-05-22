DateTimeFormatter formatter = new DateTimeFormatterBuilder()
        .parseDefaulting(ChronoField.YEAR_OF_ERA, ZonedDateTime.now().getYear()) // set default year
        .appendText(ChronoField.DAY_OF_MONTH, ordinalNumbers)
        .appendPattern(" MMM HH:mm[:ss] xxx")
        .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
        .toFormatter().withLocale(Locale.ENGLISH);
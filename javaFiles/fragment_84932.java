String str = "Tue 21st May";
    DateTimeFormatter parseFormatter = new DateTimeFormatterBuilder()
            .appendPattern("EEE d['st']['nd']['rd']['th'] MMMM")
            .parseDefaulting(ChronoField.YEAR, Year.now(ZoneId.of("Europe/London")).getValue())
            .toFormatter(Locale.ENGLISH);

    LocalDate datetext = LocalDate.parse(str, parseFormatter);
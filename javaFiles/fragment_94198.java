String oldDate = "04-07-19 02:41:39.063000000 PM";
    DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("dd-MM-yy hh:mm:ss")
                .appendFraction(ChronoField.NANO_OF_SECOND, 1, 9, true)
                .appendLiteral(' ')
                .appendText(ChronoField.AMPM_OF_DAY)
                .toFormatter();

    LocalDate parseDate = LocalDate.parse(oldDate, formatter);
    System.out.println(parseDate);
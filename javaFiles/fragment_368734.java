DateTimeFormatter formatter
            = DateTimeFormatter.ofPattern("EEEMMMddHH:mm:sszyyyy", Locale.ENGLISH);
    String dateTimeString = "TueDec2618:47:09UTC2017";
    ZonedDateTime dateTime = ZonedDateTime.parse(dateTimeString, formatter);
    long unixTimestamp = dateTime.toEpochSecond();
    System.out.println("Parsed date-time " + dateTime + " Unix timestamp " + unixTimestamp);
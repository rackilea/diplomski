String receivedDateTime = "2019-11-13T00:11:08+05:00";

    OffsetDateTime parsedDateTime = OffsetDateTime.parse(receivedDateTime);
    ZonedDateTime dateTimeInMyTimeZone
            = parsedDateTime.atZoneSameInstant(ZoneId.systemDefault());
    System.out.println(dateTimeInMyTimeZone);
ZoneId zone = ZoneId.of("Pacific/Kwajalein");
    long originalTimestamp = 1_567_318_967L;
    ZonedDateTime dateTime = Instant.ofEpochSecond(originalTimestamp).atZone(zone);

    long anHourLess = dateTime.minusHours(1).toInstant().getEpochSecond();
    System.out.println("previous hour: " + anHourLess);

    long aDayLess = dateTime.minusDays(1).toInstant().getEpochSecond();
    System.out.println("previous day: " + aDayLess);
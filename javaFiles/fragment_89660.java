Instant originalInstant = Instant.ofEpochSecond(originalTimestamp);

    long anHourLess = originalInstant.minus(1, ChronoUnit.HOURS).getEpochSecond();
    System.out.println("previous hour: " + anHourLess);

    long aDayLess = originalInstant.minus(1, ChronoUnit.DAYS).getEpochSecond();
    System.out.println("previous day: " + aDayLess);
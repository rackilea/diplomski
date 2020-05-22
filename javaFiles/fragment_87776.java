ZoneId zone = ZoneId.of("Asia/Kuala_Lumpur");
    ZonedDateTime exampleTime = ZonedDateTime.of(1905, 5, 15, 10, 34, 56, 789_000_000, zone);

    // Truncation in time zone
    long longTzTimestamp = exampleTime.truncatedTo(ChronoUnit.MINUTES)
            .toInstant()
            .toEpochMilli();
    System.out.println("After truncation in " + zone + ": " + longTzTimestamp);

    // Truncation in UTC
    long longUtcTimestamp = exampleTime.toInstant()
            .truncatedTo(ChronoUnit.MINUTES)
            .toEpochMilli();
    System.out.println("After truncation in UTC:               " + longUtcTimestamp);
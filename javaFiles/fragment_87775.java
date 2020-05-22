long exampleTimestamp = Instant.parse("1969-12-15T21:34:56.789Z").toEpochMilli();

    long with0Seconds = Instant.ofEpochMilli(exampleTimestamp)
            .atZone(ZoneId.systemDefault())
            .withNano(0)
            .withSecond(0)
            .toInstant()
            .toEpochMilli();
    System.out.println("Set seconds to 0:       " + with0Seconds);

    long dividedAndMultiplied = exampleTimestamp / 1000 / 60 * 1000 * 60;
    System.out.println("Divided and multiplied: " + dividedAndMultiplied);
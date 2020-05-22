DateTimeFormatter formatter
            = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)
                    .withLocale(Locale.GERMAN);
    ZoneId timeZoneId = ZoneId.of("Europe/Zurich");
    int totalIterations = Math.toIntExact(TimeUnit.HOURS.toSeconds(2));
    for (int sec = 0; sec < totalIterations; sec++) {
        System.out.print(ZonedDateTime.now(timeZoneId).format(formatter) + '\r');
        TimeUnit.SECONDS.sleep(1);
    }